package com.aldeamo.core.receiver.business;

import com.aldeamo.core.model.SMSMessage;

public interface MessageForwarder {
	public SMSMessage forward(SMSMessage message);
}
