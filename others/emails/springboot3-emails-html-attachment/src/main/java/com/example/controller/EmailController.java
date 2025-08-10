package com.example.controller;

import com.example.service.EmailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Value("${email.from}")
    private String emailFrom;

    @Value("${email.to}")
    private String emailTo;

    @Value("${email.subject}")
    private String emailSubject;

    @Value("${email.html}")
    private String emailHtml;

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping
    public ResponseEntity<String> send() {

        emailService.sendEmailAsHtml(emailFrom, emailTo, emailSubject, emailHtml);
        return ResponseEntity.ok("Email sent successfully");

    }

}
