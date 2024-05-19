package com.mauss.edu.mail;

import org.springframework.stereotype.Service;

@Service
public interface MailService {

    void sendMail(Mail mail, String username, String pass);
    void sendNotification(Mail mail, String subject , String fName);
}
