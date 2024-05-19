package com.mauss.edu.mail;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
@Service
@AllArgsConstructor
public class MailServiceImpl implements MailService {

    @Autowired
    private final JavaMailSender javaMailSender;

    @Override
    public void sendMail(Mail mail, String username, String pass) {
        String bdy = "Hello, "+mail.getFName() + "\n username: " + username + "\npassword: "+pass;
        MimeMessagePreparator mimeMessagePreparator = mimeMessage -> {
            MimeMessageHelper mimeMailMessage = new MimeMessageHelper(mimeMessage, "utf-8");
                mimeMailMessage.setFrom("noreplysportwear@gmail.com");
                mimeMailMessage.setText(bdy, true);
                mimeMailMessage.setSubject("Welcome to MauSS");
                mimeMailMessage.addTo(mail.getEmail());
        };
        this.javaMailSender.send(mimeMessagePreparator);
    }

    @Override
    public void sendNotification(Mail mail, String subject, String fName) {
        String msg ="Hello, "+fName;
        MimeMessagePreparator mimeMessagePreparator = mimeMessage -> {
            MimeMessageHelper mimeMailMessage = new MimeMessageHelper(mimeMessage, "utf-8");
            mimeMailMessage.setFrom("noreplysportwear@gmail.com");
            mimeMailMessage.setText(msg, true);
            mimeMailMessage.setSubject("Your Response Successfully Submitted : " + fName);
            mimeMailMessage.addTo(mail.getEmail());
        };
        this.javaMailSender.send(mimeMessagePreparator);
    }
}
