package com.aldeamo.core.processor.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.aldeamo.core.model.SMSMessage;
import com.aldeamo.core.processor.business.MessageProcessor;

@Component
public class EventConsumer {
	private final static Log log = LogFactory.getLog(EventConsumer.class);
	
	private final MessageProcessor processor;
	
	// TODO Sacar a componente compartido junto con DTOs/entities
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
