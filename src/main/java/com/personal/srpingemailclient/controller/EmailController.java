package com.personal.srpingemailclient.controller;


import com.personal.srpingemailclient.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;

@Controller
public class EmailController {

    @Autowired
    private EmailSenderService emailSenderService;

    @GetMapping("/")
    @ResponseBody
    public String getForm(){
        System.out.println("Entrando en get form");
        return "form";
    }


    @PostMapping("/email/send")
    @ResponseBody
    public void sendEmail(@RequestPart("user-email")String userEmail,
                            @RequestPart("user-body")String body,
                            @RequestPart("fileToUpload") MultipartFile file) throws MessagingException {
        System.out.println("\n entrando en sending email controller: "+userEmail+" | "+body+" | "+file+"\n");
        emailSenderService.sendEmailwithAttachment(userEmail, body, "Solicitud empleo",userEmail, file);
    }
}
