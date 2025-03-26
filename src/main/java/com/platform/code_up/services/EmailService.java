package com.platform.code_up.services;

import com.platform.code_up.dtos.MailBody;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendSimpleMessage(MailBody body) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(body.to());
        message.setFrom("usermikel18@gmail.com");
        message.setSubject(body.subject());
        message.setText(body.text());

        javaMailSender.send(message);



    }
}
