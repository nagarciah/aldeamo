package com.aldeamo.core.receiver.dto;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SMSMessage implements Serializable {

	public static enum SMSStatus {
		RECEIVED,
		SENT,
		FAILED,
		NOTIFIED,
		NOTIFICATION_FAILED
	}
	
	public static enum NotificationStatus {
		PENDING,
		NOTIFIED,
		FAILED
	}
	
	public static enum SMSDirection {
		MT,
		MO,
	} 
	
	private static final long serialVersionUID = 7858122293375326032L;
	
	// Cliente (Obligatorios)
	protected String from;
	protected String to;
	protected String content;
	
	// Cliente (Opcionales)
	protected ZonedDateTime dateScheduled;
	protected int ttl; // minutos de validez en el sistema, ttl
	protected String notificationURL;
	protected boolean testMode;
	protected int maxSpĺit;
	protected String senderCustomData;
	protected String senderCampaign;

	// Sistema
	@Id
	protected long id;
	protected UUID uuid; // Usar?? 
	protected long transactionId;

	protected ZonedDateTime dateCreated;
	protected ZonedDateTime dateUpdated;
	protected ZonedDateTime dateSent;
	protected ZonedDateTime dateNotified;
	
	protected SMSDirection direction;
	protected SMSStatus status;
	protected String statusInfo;
	protected NotificationStatus notificationStatus;
	protected String notificationInfo;
	protected String apiVersion;
	
	
	public SMSMessage(){
		
	}
	
	public SMSMessage(String from, String to, String content) {
		this.from = from;
		this.to = to;
		this.content = content;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public ZonedDateTime getDateScheduled() {
		return dateScheduled;
	}

	public void setDateScheduled(ZonedDateTime dateScheduled) {
		this.dateScheduled = dateScheduled;
	}

	public int getTtl() {
		return ttl;
	}

	public void setTtl(int ttl) {
		this.ttl = ttl;
	}

	public String getNotificationURL() {
		return notificationURL;
	}

	public void setNotificationURL(String notificationURL) {
		this.notificationURL = notificationURL;
	}

	public boolean isTestMode() {
		return testMode;
	}

	public void setTestMode(boolean testMode) {
		this.testMode = testMode;
	}

	public int getMaxSpĺit() {
		return maxSpĺit;
	}

	public void setMaxSpĺit(int maxSpĺit) {
		this.maxSpĺit = maxSpĺit;
	}

	public String getSenderCustomData() {
		return senderCustomData;
	}

	public void setSenderCustomData(String senderCustomData) {
		this.senderCustomData = senderCustomData;
	}

	public String getSenderCampaign() {
		return senderCampaign;
	}

	public void setSenderCampaign(String senderCampaign) {
		this.senderCampaign = senderCampaign;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public ZonedDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(ZonedDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public ZonedDateTime getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(ZonedDateTime dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public ZonedDateTime getDateSent() {
		return dateSent;
	}

	public void setDateSent(ZonedDateTime dateSent) {
		this.dateSent = dateSent;
	}

	public ZonedDateTime getDateNotified() {
		return dateNotified;
	}

	public void setDateNotified(ZonedDateTime dateNotified) {
		this.dateNotified = dateNotified;
	}

	public SMSDirection getDirection() {
		return direction;
	}

	public void setDirection(SMSDirection direction) {
		this.direction = direction;
	}

	public SMSStatus getStatus() {
		return status;
	}

	public void setStatus(SMSStatus status) {
		this.status = status;
	}

	public String getStatusInfo() {
		return statusInfo;
	}

	public void setStatusInfo(String statusInfo) {
		this.statusInfo = statusInfo;
	}

	public NotificationStatus getNotificationStatus() {
		return notificationStatus;
	}

	public void setNotificationStatus(NotificationStatus notificationStatus) {
		this.notificationStatus = notificationStatus;
	}

	public String getNotificationInfo() {
		return notificationInfo;
	}

	public void setNotificationInfo(String notificationInfo) {
		this.notificationInfo = notificationInfo;
	}

	public String getApiVersion() {
		return apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
