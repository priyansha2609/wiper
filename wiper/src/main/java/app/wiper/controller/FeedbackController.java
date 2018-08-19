package app.wiper.controller;

import app.wiper.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class FeedbackController
{
    @Autowired
    private FeedbackService feedbackService;

    @RequestMapping(method=RequestMethod.POST, value="/submitFeedback")
    public void submitFeedback(@RequestBody Map<String, Object> feedback)
    {
        Integer customerId = (Integer) feedback.get("customerId");
        String subject     = feedback.get("subject").toString();
        String customerFeedback    = feedback.get("feedback").toString();

        feedbackService.submitFeedback(customerId, subject, customerFeedback);
    }
}
