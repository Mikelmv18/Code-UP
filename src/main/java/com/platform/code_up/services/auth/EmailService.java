package com.platform.code_up.services.auth;

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

    public void sendEmail(MailBody body) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom("mikelvangjeli15@gmail.com");
        simpleMailMessage.setTo(body.to());
        simpleMailMessage.setSubject(body.subject());
        simpleMailMessage.setText(body.text());

        javaMailSender.send(simpleMailMessage);
    }
}
