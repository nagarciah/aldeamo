package com.aldeamo.core.receiver.business;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aldeamo.core.receiver.business.MessageProcessor;
import com.aldeamo.core.receiver.dao.SMSMessageRepository;
import com.aldeamo.core.receiver.entity.SMSMessage;
import com.aldeamo.core.receiver.service.EventProducer;

@Service
public class MessageProcessor {
	
	private final static AtomicLong COUNTER = new AtomicLong();
	private final EventProducer eventProducer;
	private final SMSMessageRepository repository;
	
	@Autowired
	public MessageProcessor(EventProducer eventProducer,
			SMSMessageRepository repository) {
		super();
		this.eventProducer = eventProducer;
		this.repository = repository;
	}

	public SMSMessage process(SMSMessage message) {
		message.setId(COUNTER.getAndIncrement());
		repository.save(message);
		eventProducer.send(message);
		
		return message;
	}	
}