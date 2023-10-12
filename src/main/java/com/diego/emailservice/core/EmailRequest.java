package com.diego.emailservice.core;

public record EmailRequest (String email, String subject, String message) {
    
}
