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

        public final Integer value;
        TRANSACTION_STATUS(Integer value)
        {
            this.value = value;
        }
    }

    public enum SUBSCRIPTION_TYPE
    {
        ONCE,
        DAILY,
        WEEKLY,
        MONTHLY,
        QUARTERLY,
        ANNUALLY
    }

    public final static String WIPER_SUPPORT_MAIL=
            "wipers.401@gmail.com";
}
