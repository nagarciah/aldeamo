package com.aldeamo.core.receiver.business;

import com.aldeamo.core.receiver.entity.SMSEntity;

public interface MessageForwarder {
	public SMSEntity forward(SMSEntity message);
}
