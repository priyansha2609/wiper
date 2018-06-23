package app.wiper.util;

import app.wiper.domain.gateway.paytm.TransactionResponseParams;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.util.Map;

public class FormUrlEncodedConverter extends
        AbstractHttpMessageConverter<TransactionResponseParams>
{
    private static final FormHttpMessageConverter formHttpMessageConverter =
            new FormHttpMessageConverter();
    private static final ObjectMapper mapper =
            new ObjectMapper();

    @Override
    protected boolean supports(Class<?> aClass)
    {
        return (TransactionResponseParams.class == aClass);
    }

    @Override
    protected TransactionResponseParams readInternal(
            Class<? extends TransactionResponseParams> aClass,
            HttpInputMessage httpInputMessage)
            throws IOException, HttpMessageNotReadableException
    {
        Map<String, String> vals =
                formHttpMessageConverter.read(
                null,
                httpInputMessage).toSingleValueMap();

        return mapper.convertValue(vals, TransactionResponseParams.class);
    }

    @Override
    protected void writeInternal(
            TransactionResponseParams transactionResponseParams,
            HttpOutputMessage httpOutputMessage)
            throws IOException, HttpMessageNotWritableException
    {

    }
}
