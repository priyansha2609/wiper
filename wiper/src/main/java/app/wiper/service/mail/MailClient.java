package app.wiper.service.mail;

import app.wiper.util.Constants;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Log4j2
public class MailClient
{
    private JavaMailSender mailSender;
    private MailContentBuilder mailContentBuilder;

    @Autowired
    public MailClient(JavaMailSender mailSender, MailContentBuilder mailContentBuilder)
    {
        this.mailSender = mailSender;
        this.mailContentBuilder = mailContentBuilder;
    }

    public void prepareAndSend(final String recipient,
                               final String subject,
                               final String template,
                               final Map<String, Object> params)
    {
        MimeMessagePreparator messagePreparator =
            mimeMessage -> {
                MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
                messageHelper.setFrom(Constants.WIPER_SUPPORT_MAIL, "Wiper Support");
                messageHelper.setTo(recipient);
                messageHelper.setSubject(subject);

                params.put("replyMail", "mailto:" + Constants.WIPER_SUPPORT_MAIL);
                String content = mailContentBuilder.build(template, params);

                messageHelper.setText(content, true);
            };

        try {
            mailSender.send(messagePreparator);
        }
        catch (MailException e) {
            log.log(Level.FATAL, "Failed to send mail: " + e.getMessage());
        }
    }
}
