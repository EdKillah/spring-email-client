package com.personal.srpingemailclient.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String emailFrom;

    public void sendSimpleEmail(String toEmail,
                                String body,
                                String subject){

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom(emailFrom);
        simpleMailMessage.setTo(toEmail);
        simpleMailMessage.setText(body);
        simpleMailMessage.setSubject(subject);

        //we send the email
        mailSender.send(simpleMailMessage);
        System.out.println("Mail send: "+simpleMailMessage.toString());
    }

    public void sendEmailwithAttachment(String toEMail,
                                        String body,
                                        String subject,
                                        String attachment,
                                        MultipartFile file) throws MessagingException {


        String fileName = attachment.split("@")[0]+"-CV";

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);

        messageHelper.setFrom(emailFrom);
        messageHelper.setTo(toEMail);
        messageHelper.setText(body);
        messageHelper.setSubject(subject);
        messageHelper.addAttachment(fileName, file);
        mailSender.send(mimeMessage);
        System.out.println("Email sended: "+mailSender.toString());
    }

}
