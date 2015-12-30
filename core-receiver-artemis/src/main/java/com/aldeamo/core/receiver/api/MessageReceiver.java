package com.aldeamo.core.receiver.api;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aldeamo.core.model.SMSMessage;
import com.aldeamo.core.receiver.business.MessageForwarder;

@RestController
public class MessageReceiver {

	private final static Log log = LogFactory.getLog(MessageReceiver.class);

	@Autowired
	private MessageForwarder forwarder;

	/**
	 * Crea (envía) un mensaje sms
	 * 
	 * @param msg
	 */
	@RequestMapping(value = "/sms", method = RequestMethod.POST)
	public SMSMessage sendSMS(@RequestBody SMSMessage msg) {
		log.info("Mensaje recibido: " + msg);
		return forwarder.forward(msg);
	}

//	@RequestMapping(value = "/sms", method = RequestMethod.GET)
//	public SMSMessage getAll() {
//		return new SMSMessage("origin", "target", "content");
//	}
}
