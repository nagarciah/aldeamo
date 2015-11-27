package com.aldeamo.core.receiver.business.impl;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.aldeamo.core.receiver.business.MessageForwarder;
import com.aldeamo.core.receiver.entity.SMSMessage;

@Service
public class MessageSenderImpl implements MessageForwarder {
	
	private static final String SIMPLE_QUEUE = "simple.queue";
	private final static AtomicLong COUNTER = new AtomicLong();
	private final JmsTemplate jmsTemplate;
	
	@Autowired
	public MessageSenderImpl(JmsTemplate jmsTemplate) {
		super();
		this.jmsTemplate = jmsTemplate;
	}

	@Override
	public SMSMessage forward(SMSMessage message) {
		message.setId(COUNTER.getAndIncrement());
		jmsTemplate.convertAndSend(SIMPLE_QUEUE, message);
		
		return message;
	}	
}
