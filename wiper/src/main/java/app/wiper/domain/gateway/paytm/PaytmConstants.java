package app.wiper.domain.gateway.paytm;


import lombok.Getter;

public class PaytmConstants
{
    @Getter
    public enum MERCHANT_CONSTS
    {
        MERCHANT_ID("WiperS96733632560363"),
        MERCHANT_KEY("8u@fS6NCYe@Z@7d%"),
        INDUSTRY_TYPE_ID("Retail"),
        CHANNEL_ID("WAP"),
        WEBSITE_STAGING("APPSTAGING"),
        CALLBACK_URL_STAGING("https://securegw-stage.paytm.in/theia/paytmCallback?ORDER_ID=");

        private final String value;
        MERCHANT_CONSTS(String value)
        {
            this.value = value;
        }
    }

    @Getter
    public enum PAYLOAD_PARAMETERS
    {
        MERCHANT_ID("MID"),
        MERCHANT_KEY("MERCHANT_KEY"),
        INDUSTRY_TYPE_ID("INDUSTRY_TYPE_ID"),
        CHANNEL_ID("CHANNEL_ID"),
        WEBSITE("WEBSITE"),
        CALLBACK_URL("CALLBACK_URL"),
        ORDER_ID("ORDERID"),
        TXN_AMOUNT("TXNAMOUNT"),
        CURRENCY("CURRENCY"),
        TXN_ID("TXNID"),
        BANK_TXN_ID("BANK_TXN_ID"),
        STATUS("STATUS"),
        RESPONSE_CODE("RESPCODE"),
        RESPONSE_MSG("RESPMSG"),
        TXN_DATE("TXNDATE"),
        GATEWAY_NAME("GATEWAYNAME"),
        BANK_NAME("BANKNAME"),
        PAYMENT_MODE("PAYMENT_MODE"),
        CHECKSUM_HASH("CHECKSUMHASH"),
        CUSTOMER_ID("CUST_ID"),
        EMAIL("EMAIL"),
        PHONE("MOBILE_NO");

        private final String value;
        PAYLOAD_PARAMETERS(String paramName)
        {
            this.value = paramName;
        }
    }

    @Getter
    public enum RESPONSE_CODES
    {
        TXN_SUCCESS(1, "Successful transaction"),

        // Failure codes by user actions.
        CANCEL_BY_CUSTOMER_AFTER_LOGIN(141, "Cancel Request by Customer( After page load)"),
        CANCEL_BY_CUSTOMER_AT_LOGIN(142, "Cancel Request by Customer at login screen"),
        CANCEL_BY_CUSTOMER_BEFORE_LOGIN(143, "Cancel Request by Customer before login screen is displayed properly"),
        CLOSED_BEFORE_PAGE_LOAD(410, "Closed before page load"),
        CLOSED_AFTER_PAGE_LOAD(810, "Closed after page load"),
        CANCEL_BY_CUSTOMER_BEFORE_PAGE_LOAD(841, "Cancel Request by Customer(Before page load)"),
        CANCEL_BY_CUSTOMER_AT_BANK_PAGE(2271, "User cancelled the transaction on banks net banking page"),
        INACTIVE_USER_WALLET(8101, "User wallet is Inactive"),
        PAGE_CLOSED_SUFFICIENT_BALANCE(8102, "Page Closed Post login with Sufficient Wallet Balance"),
        PAGE_CLOSED_INSUFFICIENT_BALANCE(8103, "Page Closed Post login with Insufficient Wallet Balance");

        // Need to add other failure codes as described on the Paytm developers code.
        private int code;
        private String description;
        RESPONSE_CODES(int code, String description)
        {
            this.code = code;
            this.description = description;
        }
    }

    @Getter
    public enum BANK_CODES
    {
        ICICI("ICICI"),
        HDFC ("HDFC"),
        AXIS ("AXIS");

        // Similarly need to add codes for other banks as defined on the
        // banks page.

        private String value;

        BANK_CODES(String value)
        {
            this.value = value;
        }
    }

    public enum PAYMENT_MODES
    {
        CC("Credit card"),
        DC("Debit card"),
        Wallet("Paytm wallet"),
        IMPS("IMPS"),
        PPI("PPI");

        private String value;
        PAYMENT_MODES(String value)
        {
            this.value = value;
        }
    }
}

