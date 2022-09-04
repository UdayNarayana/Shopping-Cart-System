package com.eshopping.email.model;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.eshopping.email.config.MQConfig;

import lombok.Getter;

@Component
@Getter
public class MessageListener {
	
	private EmailBody email;

	@RabbitListener(queues = MQConfig.QUEUE)
	public void getMessageFromQueue(EmailBody mail) {
      email = mail;
	}
	
}
