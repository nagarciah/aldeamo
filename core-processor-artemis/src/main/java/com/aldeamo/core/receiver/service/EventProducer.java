package com.aldeamo.core.receiver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.aldeamo.core.receiver.dto.SMSMessage;

@Service
public class EventProducer {
	
	private static final String EVENT_SINK = "core.processor.out.queue";
	private final JmsTemplate jmsTemplate;
	
	@Autowired
	public EventProducer(JmsTemplate jmsTemplate) {
		super();
		this.jmsTemplate = jmsTemplate;
	}

	public SMSMessage send(SMSMessage message) {
		jmsTemplate.convertAndSend(EVENT_SINK, message);
		
		return message;
	}	
}
