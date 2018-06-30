package app.wiper.util;

import lombok.Getter;

import java.util.Arrays;

public class Constants
{
    @Getter
    public enum TRANSACTION_STATUS
    {
        FAILURE(0),
        SUCCESS(1),
        PENDING(2),
        OPEN(3),
        UNKNOWN(4);

        private final Integer value;
        TRANSACTION_STATUS(Integer value)
        {
            this.value = value;
        }

        public TRANSACTION_STATUS getTransactionStatusById(Integer value)
        {
            return Arrays.stream(TRANSACTION_STATUS.values())
                    .filter(v -> v.value.equals(value))
                    .findFirst()
                    .get();
        }
    }

    @Getter
    public enum SUBSCRIPTION_TYPE
    {
        DAILY,
        WEEKLY,
        MONTHLY,
        QUARTERLY,
        ANNUALLY;

//        private Integer subscriptionTypeId;
//        SUBSCRIPTION_TYPE(Integer id)
//        {
//            subscriptionTypeId = id;
//        }
//
//        public SUBSCRIPTION_TYPE getSubscriptionTypeById(Integer id)
//        {
//            return Arrays.stream(SUBSCRIPTION_TYPE.values())
//                    .filter(v -> v.subscriptionTypeId.equals(id))
//                    .findFirst()
//                    .get();
//        }
    }
}
