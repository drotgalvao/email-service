package com.diego.emailservice.adapters;

public interface EmailSenderGateway {

    void sendEmail(String email, String subject, String message);

    
    
}
