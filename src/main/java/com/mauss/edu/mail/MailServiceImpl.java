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
//        String bdy = "Hello, "+mail.getFName() + "\n username: " + username + "\npassword: "+pass;
        String bdy = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Welcome Email</title>\n" +
                "    <style>\n" +
                "        body {\n" +
                "            font-family: Arial, sans-serif;\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "            background-color: #f8f9fa;\n" +
                "        }\n" +
                "        .container {\n" +
                "            max-width: 600px;\n" +
                "            margin: 0 auto;\n" +
                "            background-color: #ffffff;\n" +
                "            border: 1px solid #e0e0e0;\n" +
                "            border-radius: 8px;\n" +
                "            overflow: hidden;\n" +
                "        }\n" +
                "        .header {\n" +
                "            background-color: #006400;\n" +
                "            color: #ffffff;\n" +
                "            padding: 20px;\n" +
                "            text-align: center;\n" +
                "            font-size: 24px;\n" +
                "        }\n" +
                "        .content {\n" +
                "            padding: 30px;\n" +
                "            color: #333333;\n" +
                "        }\n" +
                "        .credentials {\n" +
                "            margin: 20px 0;\n" +
                "        }\n" +
                "        .credentials span {\n" +
                "            font-weight: bold;\n" +
                "            color: #006400;\n" +
                "        }\n" +
                "        .footer {\n" +
                "            padding: 20px;\n" +
                "            background-color: #f8f9fa;\n" +
                "            text-align: center;\n" +
                "            font-size: 14px;\n" +
                "            color: #888888;\n" +
                "        }\n" +
                "        a {\n" +
                "            color: #006400;\n" +
                "            text-decoration: none;\n" +
                "        }\n" +
                "        .btn {\n" +
                "            display: inline-block;\n" +
                "            padding: 10px 20px;\n" +
                "            margin-top: 20px;\n" +
                "            background-color: #006400;\n" +
                "            color: #ffffff;\n" +
                "            text-decoration: none;\n" +
                "            border-radius: 5px;\n" +
                "        }\n" +
                "        .btn:hover {\n" +
                "            background-color: #004d00;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"container\">\n" +
                "        <div class=\"header\">\n" +
                "            Welcome to Mattu University Special School\n" +
                "        </div>\n" +
                "        <div class=\"content\">\n" +
                "            <p>Dear , "+mail.getFName()+"</p>\n" +
                "            <p>Thank you for registering at Mattu University Special School. We are excited to have you join our community!</p>\n" +
                "            <p>Here are your login credentials:</p>\n" +
                "            <div class=\"credentials\">\n" +
                "                <p>Username: <span>"+username+"</span></p>\n" +
                "                <p>Password: <span>"+pass+"</span></p>\n" +
                "            </div>\n" +
                "            <p>Please keep these credentials safe and do not share them with anyone. You can log in to your account using the button below:</p>\n" +
                "            <a href=\"http://localhost:8080\" class=\"btn\">Log In to Your Account</a>\n" +
                "            <p>If you have any questions, feel free to <a href=\"mailto:support@mattu.edu\">contact our support team</a>.</p>\n" +
                "            <p>Best regards,<br>Mattu University Special School Team</p>\n" +
                "        </div>\n" +
                "        <div class=\"footer\">\n" +
                "            &copy; 2024 Mattu University Special School. All rights reserved.\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>\n";
        MimeMessagePreparator mimeMessagePreparator = mimeMessage -> {
            MimeMessageHelper mimeMailMessage = new MimeMessageHelper(mimeMessage, "utf-8");
            mimeMailMessage.setFrom("noreplysportwear@gmail.com", "MAUSS TEAM");
            mimeMailMessage.setText(bdy, true);
                mimeMailMessage.setSubject("Welcome to MauSS");
                mimeMailMessage.addTo(mail.getEmail());
        };
        this.javaMailSender.send(mimeMessagePreparator);
    }

    @Override
    public void sendNotification(String subject, String message, String fullName, String email){
        String msg = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Contact Us Confirmation</title>\n" +
                "    <style>\n" +
                "        body {\n" +
                "            font-family: Arial, sans-serif;\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "            background-color: #f8f9fa;\n" +
                "        }\n" +
                "        .container {\n" +
                "            max-width: 600px;\n" +
                "            margin: 0 auto;\n" +
                "            background-color: #ffffff;\n" +
                "            border: 1px solid #e0e0e0;\n" +
                "            border-radius: 8px;\n" +
                "            overflow: hidden;\n" +
                "        }\n" +
                "        .header {\n" +
                "            background-color: #006400;\n" +
                "            color: #ffffff;\n" +
                "            padding: 20px;\n" +
                "            text-align: center;\n" +
                "            font-size: 24px;\n" +
                "        }\n" +
                "        .content {\n" +
                "            padding: 30px;\n" +
                "            color: #333333;\n" +
                "        }\n" +
                "        .message {\n" +
                "            margin: 20px 0;\n" +
                "            background-color: #f1f1f1;\n" +
                "            padding: 15px;\n" +
                "            border-left: 4px solid #006400;\n" +
                "        }\n" +
                "        .message p {\n" +
                "            margin: 0;\n" +
                "            color: #333333;\n" +
                "        }\n" +
                "        .footer {\n" +
                "            padding: 20px;\n" +
                "            background-color: #f8f9fa;\n" +
                "            text-align: center;\n" +
                "            font-size: 14px;\n" +
                "            color: #888888;\n" +
                "        }\n" +
                "        a {\n" +
                "            color: #006400;\n" +
                "            text-decoration: none;\n" +
                "        }\n" +
                "        .btn {\n" +
                "            display: inline-block;\n" +
                "            padding: 10px 20px;\n" +
                "            margin-top: 20px;\n" +
                "            background-color: #006400;\n" +
                "            color: #ffffff;\n" +
                "            text-decoration: none;\n" +
                "            border-radius: 5px;\n" +
                "        }\n" +
                "        .btn:hover {\n" +
                "            background-color: #004d00;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"container\">\n" +
                "        <div class=\"header\">\n" +
                "            Form Submission Confirmation\n" +
                "        </div>\n" +
                "        <div class=\"content\">\n" +
                "            <p>Dear, "+fullName+",</p>\n" +
                "            <p>Thank you for reaching out to Mattu University Special School. We have received your message and will get back to you as soon as possible.</p>\n" +
                "            <p>Here is a copy of your message for your records:</p>\n" +
                "            <div class=\"message\">\n" +
                "                <p><strong>Subject:</strong> "+subject+"</p>\n" +
                "                <p><strong>Message:</strong> </p>\n" +
                "                <p>"+message+"</p>\n" +
                "            </div>\n" +
                "            <p>If you have any additional information to provide or further questions, please feel free to <a href=\"mailto:support@mattu.edu\">contact our support team</a>.</p>\n" +
                "            <p>Best regards,<br>Mattu University Special School Team</p>\n" +
                "        </div>\n" +
                "        <div class=\"footer\">\n" +
                "            &copy; 2024 Mattu University Special School. All rights reserved.\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>\n";
        MimeMessagePreparator mimeMessagePreparator = mimeMessage -> {
            MimeMessageHelper mimeMailMessage = new MimeMessageHelper(mimeMessage, "utf-8");
            mimeMailMessage.setFrom("noreplysportwear@gmail.com", "MAUSS TEAM");
            mimeMailMessage.setText(msg, true);
            mimeMailMessage.setSubject("Your Response Successfully Submitted : " + fullName);
            mimeMailMessage.addTo(email);
        };
        this.javaMailSender.send(mimeMessagePreparator);
    }
}
