package com.aldeamo.core.receiver.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.aldeamo.core.receiver.dto.SMSMessage;

@Entity
public class SMSEntity extends SMSMessage implements Serializable {

	private static final long serialVersionUID = 3594644791112896667L;

	@Id
	public long getId() {
		return super.getId();
	}
}
