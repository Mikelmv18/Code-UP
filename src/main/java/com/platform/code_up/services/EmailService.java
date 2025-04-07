package com.platform.code_up.services;

import com.platform.code_up.dtos.MailBody;
import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.io.IOException;

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
