package com.aldeamo.core.receiver.business;

import com.aldeamo.core.receiver.entity.SMSMessage;

public interface MessageForwarder {
	public SMSMessage forward(SMSMessage message);
}
