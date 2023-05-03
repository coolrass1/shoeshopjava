package com.skkgroup.shoes.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl {
    @Autowired
    private EmailService emailservice;
    @Autowired
    private  SimpleMailMessage message ;

    public void sendSimpleMessage( String to, String subject, String text){


        message.setFrom("noreply@baeldung.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        emailservice.getJavaMailSender().send(message);
    }

}
