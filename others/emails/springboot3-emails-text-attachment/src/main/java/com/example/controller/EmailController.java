package com.example.controller;

import com.example.service.EmailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
public class EmailController {

    @Value("${email.from}")
    private String emailFrom;

    @Value("${email.to}")
    private String emailTo;

    @Value("${email.subject}")
    private String emailSubject;

    @Value("${email.text}")
    private String emailText;

    @Value("${email.attachment}")
    private String emailAttachment;

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping
    public ResponseEntity<String> send() {

        File attachment = new File(emailAttachment);
        emailService.sendEmailAsTextWithAttachment(emailFrom, emailTo, emailSubject, emailText, attachment);
        return ResponseEntity.ok("Email sent successfully");

    }

}
