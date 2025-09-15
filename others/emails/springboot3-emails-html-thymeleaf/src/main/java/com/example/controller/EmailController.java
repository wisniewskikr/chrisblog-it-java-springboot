package com.example.controller;

import com.example.service.EmailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class EmailController {

    @Value("${email.from}")
    private String emailFrom;

    @Value("${email.to}")
    private String emailTo;

    @Value("${email.subject}")
    private String emailSubject;

    @Value("${email.template}")
    private String emailTemplate;

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping
    public ResponseEntity<String> send() {

        Map<String, Object> variables = Map.of("username", "Stranger");
        emailService.sendEmailFromTemplate(emailFrom, emailTo, emailSubject, emailTemplate, variables);
        return ResponseEntity.ok("Email sent successfully");

    }

}
