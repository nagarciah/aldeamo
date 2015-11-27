package com.aldeamo.core.receiver.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.aldeamo.core.receiver.entity.SMSMessage;

@Component
public class SimpleListener {
	private final static Log log = LogFactory.getLog(SimpleListener.class);
	
	@JmsListener(destination="simple.queue")
	public void send(SMSMessage message){
		//log.info("Mensaje recibido de la cola: ");
		log.info(message);
	}
}
