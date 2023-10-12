package com.diego.emailservice.infra.ses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.diego.emailservice.adapters.EmailSenderGateway;
import com.diego.emailservice.core.exceptions.EmailServiceException;

@Service
public class SesEmailSender implements EmailSenderGateway {

    private final AmazonSimpleEmailService amazonSimpleEmailService;

    @Autowired
    public SesEmailSender(AmazonSimpleEmailService amazonSimpleEmailService) {
        this.amazonSimpleEmailService = amazonSimpleEmailService;
    }

    @Override
    public void sendEmail(String email, String subject, String message) {
        SendEmailRequest request = new SendEmailRequest()
                .withSource("diegohenriquegalvao@gmail.com")
                .withDestination(
                        new Destination()
                                .withToAddresses(email)

                )
                .withMessage(
                        new Message()
                                .withSubject(
                                        new Content(subject))
                                .withBody(
                                        new Body()
                                                .withText(
                                                        new Content(message))));

        try {
            amazonSimpleEmailService.sendEmail(request);
        } catch (AmazonServiceException exception) {
            throw new EmailServiceException("Failure while sending email", exception);

        }
    }

}
