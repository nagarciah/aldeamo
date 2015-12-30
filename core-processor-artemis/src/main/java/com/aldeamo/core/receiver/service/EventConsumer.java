package com.aldeamo.core.receiver.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.aldeamo.core.receiver.business.MessageProcessor;
import com.aldeamo.core.receiver.entity.SMSMessage;

@Component
public class EventConsumer {
	private final static Log log = LogFactory.getLog(EventConsumer.class);
	
	private final MessageProcessor processor;
	
	public static final String EVENT_SOURCE = "core.processor.in.queue";
	
	@Autowired
	public EventConsumer(MessageProcessor processor) {
		super();
		this.processor = processor;
	}
	
	@JmsListener(destination=EVENT_SOURCE)
	public void consume(SMSMessage message){
		log.info("Mensaje recibido de la cola: \n" + message);
		processor.process(message);		
	}
}
