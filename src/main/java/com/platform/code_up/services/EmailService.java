package com.platform.code_up.services;

import com.platform.code_up.dtos.MailBody;
import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class EmailService {

    private final String sendGridApiKey = "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";  // Replace with your actual SendGrid API key

    public void sendSimpleMessage(MailBody body) {

        Email from = new Email("mikelvangjeli15@gmail.com");
        String subject = body.subject();
        Email to = new Email(body.to());
        Content content = new Content("text/plain", body.text());
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(sendGridApiKey);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            throw new RuntimeException("Email failure");
        }
    }
}
