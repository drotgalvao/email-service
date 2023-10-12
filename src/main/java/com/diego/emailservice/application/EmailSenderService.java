package com.diego.emailservice.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diego.emailservice.adapters.EmailSenderGateway;
import com.diego.emailservice.core.EmailSenderUseCase;

@Service
public class EmailSenderService implements EmailSenderUseCase {

    private final EmailSenderGateway emailSenderGateway;

    @Autowired
    public EmailSenderService(EmailSenderGateway emailGateway) {
        this.emailSenderGateway = emailGateway;
    }

    @Override
    public void sendEmail(String email, String subject, String message) {

        this.emailSenderGateway.sendEmail(email, subject, message);
        
    }
    
}
