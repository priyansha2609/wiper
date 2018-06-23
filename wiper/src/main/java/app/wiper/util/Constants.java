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
}
