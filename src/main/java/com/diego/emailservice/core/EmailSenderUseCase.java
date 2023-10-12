package com.diego.emailservice.core;

public interface EmailSenderUseCase {
    void sendEmail(String email, String subject, String message);
    
}
