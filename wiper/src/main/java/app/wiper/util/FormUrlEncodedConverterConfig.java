package app.wiper.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

@Configuration
public class FormUrlEncodedConverterConfig extends WebMvcConfigurerAdapter
{
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters)
    {
        FormUrlEncodedConverter formUrlEncodedConverter = new FormUrlEncodedConverter();
        MediaType mediaType = new MediaType("application",
                                            "x-www-form-urlencoded",
                                            Charset.forName("UTF-8"));

        formUrlEncodedConverter.setSupportedMediaTypes(Arrays.asList(mediaType));
        converters.add(formUrlEncodedConverter);
        super.configureMessageConverters(converters);
    }
}
