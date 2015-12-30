package com.aldeamo.core.receiver.business.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.aldeamo.core.model.SMSMessage;
import com.aldeamo.core.receiver.business.MessageForwarder;

@Service
public class MessageSenderImpl implements MessageForwarder {
	
	private static final String EVENT_SINK = "core.processor.in.queue";
	private final JmsTemplate jmsTemplate;
	
	@Autowired
	public MessageSenderImpl(JmsTemplate jmsTemplate) {
		super();
		this.jmsTemplate = jmsTemplate;
	}

	@Override
	public SMSMessage forward(SMSMessage message) {
		message.setUuid(UUID.randomUUID());
		jmsTemplate.convertAndSend(EVENT_SINK, message);
		
		return message;
	}	
}
