package com.eshopping.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eshopping.email.model.EmailBody;
import com.eshopping.email.model.MessageListener;

@RestController
@RequestMapping("/email")
public class EmailController {
	
	@Value("${spring.mail.username}")
	private String fromMail;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private MessageListener listener;
	
//	EmailBody email = new EmailBody();
	
	public void sendEmail(String toEmail,
			  String body,
			  String subject) {
		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom(fromMail);
		message.setTo(toEmail);
		message.setText(body);	
		message.setSubject(subject);

		mailSender.send(message);
	}

	
	@PostMapping("/send-mail")
	public void sendMail() {
		EmailBody email = listener.getEmail();
		
		sendEmail(email.getToMail(), email.getBody(), email.getSubject());
		
	}
	
}
