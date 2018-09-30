package app.wiper.domain.core;

import app.wiper.domain.type.ServiceType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Coupon
{
    Integer couponId;
    String couponCode;
    Date startDate;
    Date endDate;
    Boolean isActive;
    String eligibilityCode;
    Double basicDiscountPercent;
    Double taxDiscountPercent;
    Double totalDiscountPercent;
    Double discountLimitAmount;
    List<ServiceType> eligibleServiceTypes;
}
