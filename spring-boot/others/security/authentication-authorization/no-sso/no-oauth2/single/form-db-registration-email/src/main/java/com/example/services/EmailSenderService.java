package com.example.services;

import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.util.MapUtils;

@Service
public class EmailSenderService {
	
    private JavaMailSender mailSender;
	
    private TemplateEngine templateEngine;
	
	@Autowired
    public EmailSenderService(JavaMailSender mailSender, TemplateEngine templateEngine) {
		this.mailSender = mailSender;
		this.templateEngine = templateEngine;
	}

	public void sendEmailText(
    		String from, 
    		String to,
    		String subject, 
    		String text) {
    	
        try {
            final MimeMessage mail = mailSender.createMimeMessage();
            final MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(to);
            helper.setFrom(from);
            helper.setSubject(subject);
            helper.setText(text, true);            
            mailSender.send(mail);
        } catch (MessagingException | MailException e) {        	
        	System.err.println(e);
        }
        
    }
	
	public void sendEmailHtml(
    		String from, 
    		String to, 
    		String subject, 
    		String template, 
    		Map<String, Object> thymeleafProperties) {
        	
        final Context context = new Context();

        if (!MapUtils.isEmpty(thymeleafProperties)) {
            context.setVariables(thymeleafProperties);
        }
        final String htmlBody = templateEngine.process(template, context);
        sendEmailText(from, to, subject, htmlBody);
        
    }

}
