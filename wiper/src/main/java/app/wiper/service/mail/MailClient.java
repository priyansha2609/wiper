package app.wiper.service.mail;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

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
                               final String message)
    {
        MimeMessagePreparator messagePreparator =
            mimeMessage -> {
                MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
                messageHelper.setFrom("wipers.401@gmail.com", "Wiper Support");
                messageHelper.setTo(recipient);
                messageHelper.setSubject(subject);

                String content = mailContentBuilder.build(message);

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
