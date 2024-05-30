package com.mauss.edu.mail;

import org.springframework.stereotype.Service;

@Service
public interface MailService {

    void sendMail(Mail mail, String username, String pass);
    void sendNotification(String subject , String message, String fullName, String email);
}
