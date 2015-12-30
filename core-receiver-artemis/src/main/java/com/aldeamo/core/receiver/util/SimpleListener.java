package com.aldeamo.core.receiver.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.aldeamo.core.receiver.dao.SMSMessageRepository;
import com.aldeamo.core.receiver.entity.SMSEntity;

@Component
public class SimpleListener {
	private final static Log log = LogFactory.getLog(SimpleListener.class);
	
	@Autowired
	private SMSMessageRepository repository;
	
	@JmsListener(destination="simple.queue")
	public void send(SMSEntity message){
		//log.info("Mensaje recibido de la cola: ");
		log.info(message);
		repository.save(message);		
	}
}
