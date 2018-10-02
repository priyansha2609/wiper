package app.wiper.crons;

import app.wiper.domain.core.Customer;
import app.wiper.domain.core.ServiceDetails;
import app.wiper.service.CustomerService;
import app.wiper.service.ServiceDetailsService;
import app.wiper.service.VehicleService;
import app.wiper.service.mail.MailClient;
import app.wiper.util.Constants;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

/**
 * This task checks for active subscriptions that have expired today and
 * marks them as inactive.
 */
@Component
@Log4j2
public class ExpireSubscriptions
{
    @Autowired
    private ServiceDetailsService serviceDetailsService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private MailClient mailClient;

    /**
     * Returns a list of subscriptions which are expiring on the given date.
     */
    private List<ServiceDetails> getSubscriptionsToExpire(Date today)
    {
        List<ServiceDetails> activeSubscriptions =
            serviceDetailsService.getAllActiveSubscriptions();

        return
            activeSubscriptions.stream()
                               .filter(
                                   s -> s.getSubscriptionEndDate().equals(today) ||
                                       s.getSubscriptionEndDate().before(today)
                               )
                               .collect(Collectors.toList());
    }

    /**
     * Marks the active services as inactive for which the subscription end
     * date is today.
     *
     * This cron job runs every day at 23:59 hours IST.
     */
    @Scheduled(cron="0 59 23 * * *", zone="IST")
    public void expireActiveServices()
    {
        Date today = Date.from(Instant.now());
        List<ServiceDetails> subscriptionsToExpire =
            getSubscriptionsToExpire(today);
        log.info("Marking following subscriptions as inactive: " +
            subscriptionsToExpire.stream()
                                 .map(s -> s.getVehicleId().toString())
                                 .collect(Collectors.joining(", ")));
        subscriptionsToExpire.forEach(s -> s.setIsActive(false));
        subscriptionsToExpire.forEach(
            serviceDetailsService::updateServiceDetails
        );

        Map<Integer, List<ServiceDetails>> custToSubscriptionsMap =
            new HashMap<>();
        for (ServiceDetails sd : subscriptionsToExpire) {
            if (!custToSubscriptionsMap.containsKey(sd.getOrder().getCustomerId())) {
                custToSubscriptionsMap.put(sd.getOrder().getCustomerId(), new ArrayList<>());
            }

            custToSubscriptionsMap.get(sd.getOrder().getCustomerId()).add(sd);
        }

        // Notify customers.
        notifyExpirationsToCustomers(custToSubscriptionsMap);
        notifyExpirationsToAdmin(custToSubscriptionsMap, today);
    }

    /**
     * Sends a notification to the customers with regarding the subscriptions
     * which have just expired.
     */
    private void notifyExpirationsToCustomers(
        Map<Integer, List<ServiceDetails>> custToSubscriptionsMap)
    {
        String subject = "Your subscription has expired!";
        for (Integer custId: custToSubscriptionsMap.keySet()) {
            Customer customer =
                customerService.getCustomerById(custId);
            Map<String, Object> params = new HashMap<>();
            params.put("customerName", customer.getName());
            List<ServiceDetails> expiredSubs = custToSubscriptionsMap.get(custId);

            Map<Integer, String> vehicleNameMap = expiredSubs.stream()
                .collect(
                    Collectors.toMap(ServiceDetails::getVehicleId,
                    sd -> vehicleService.getVehicleById(sd.getVehicleId())
                        .getVehicleNumber(),
                    (a, b) -> b)
                );

            params.put("serviceDetails", expiredSubs);
            params.put("vehicleMap", vehicleNameMap);
            mailClient.prepareAndSend(
                customer.getCredentials().getEmailId(),
                subject,
                "ExpiredSubscriptionNotificationTemplate",
                params);
        }
    }

    /**
     * Sends a notification to wiper admin /support with the list of all
     * expired subscription.
     */
    private void notifyExpirationsToAdmin(
        Map<Integer, List<ServiceDetails>> custToSubscriptionsMap, Date date)
    {
        String subject = "Expired subscriptions for date " + date + "!";

        Map<Integer, String> custIdToName = new HashMap<>();
        Map<Integer, String> vehicleNameMap = new HashMap<>();

        Map<String, Object> params = new HashMap<>();
        for (Integer custId: custToSubscriptionsMap.keySet()) {
            Customer customer =
                customerService.getCustomerById(custId);
            custIdToName.put(custId, customer.getName());
            List<ServiceDetails> expiredSubs = custToSubscriptionsMap.get(custId);

            vehicleNameMap.putAll(expiredSubs.stream()
                .collect(
                    Collectors.toMap(ServiceDetails::getVehicleId,
                        sd -> vehicleService.getVehicleById(sd.getVehicleId())
                            .getVehicleNumber(),
                        (a, b) -> b)
                ));
        }

        params.put("date", date);
        params.put("vehicleMap", vehicleNameMap);
        params.put("customerMap", custIdToName);
        params.put("serviceDetails", custToSubscriptionsMap.values());
        mailClient.prepareAndSend(
            Constants.WIPER_SUPPORT_MAIL,
            subject,
            "ExpiredSubscriptionNotificationTemplate",
            params);
    }
}
