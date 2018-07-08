package app.wiper.service.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Map;

@Service
public class MailContentBuilder
{
    private TemplateEngine templateEngine;

    @Autowired
    public MailContentBuilder(TemplateEngine templateEngine)
    {
        this.templateEngine = templateEngine;
    }

    public String build(String template, Map<String, Object> params)
    {
        Context context = new Context();
        params.forEach(context::setVariable);

        return templateEngine.process(template, context);
    }
}
