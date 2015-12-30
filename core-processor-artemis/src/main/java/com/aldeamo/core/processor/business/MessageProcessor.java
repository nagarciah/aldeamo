package com.aldeamo.core.processor.business;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aldeamo.core.model.SMSMessage;
import com.aldeamo.core.processor.dao.SMSMessageRepository;
import com.aldeamo.core.processor.service.EventProducer;

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