package com.aldeamo.core.receiver.entity;

import java.io.Serializable;

public class SMSMessage implements Serializable {
	
	private static final long serialVersionUID = 7858122293375326032L;
	
	protected Long id;
	protected String gsmOrigin;
	protected String gsmTarget;
	protected String content;

	public SMSMessage() {
		super();
	}

	public SMSMessage(Long id, String gsmOrigin, String gsmTarget, String content) {
		super();
		this.id = id;
		this.gsmOrigin = gsmOrigin;
		this.gsmTarget = gsmTarget;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGsmOrigin() {
		return gsmOrigin;
	}

	public void setGsmOrigin(String gsmOrigin) {
		this.gsmOrigin = gsmOrigin;
	}

	public String getGsmTarget() {
		return gsmTarget;
	}

	public void setGsmTarget(String gsmTarget) {
		this.gsmTarget = gsmTarget;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder
			.append("SMSMessage [id=")
			.append(id)
			.append(", gsmOrigin=")
			.append(gsmOrigin)
			.append(", gsmTarget=")
			.append(gsmTarget)
			.append(", content=")
			.append(content).append("]");
		return builder.toString();	
	}
}
