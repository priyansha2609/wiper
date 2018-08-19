package app.wiper.service;

import org.springframework.stereotype.Service;

@Service
public interface FeedbackService
{
    void submitFeedback(Integer customerId, String subject, String feedback);
}
