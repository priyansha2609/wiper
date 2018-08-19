package app.wiper.service.impl;

import app.wiper.domain.core.Customer;
import app.wiper.service.CustomerService;
import app.wiper.service.FeedbackService;
import app.wiper.service.mail.MailClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FeedbackServiceImpl implements FeedbackService
{
    @Autowired
    private CustomerService customerService;

    @Autowired
    private MailClient mailClient;

    @Override
    public void submitFeedback(Integer customerId, String subject, String feedback)
    {
        Customer customer = customerService.getCustomerById(customerId);
        Map<String, Object> params = new HashMap<>();
        params.put("customerName", customer.getName());
        params.put("feedback", feedback);
        mailClient.prepareAndSend(
            customer.getCredentials().getEmailId(),
            subject,
            "FeedbackMail",
            params);
    }
}
