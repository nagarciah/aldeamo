package com.aldeamo.core.receiver.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.aldeamo.core.receiver.entity.SMSMessage;

@Component
public interface SMSMessageRepository extends JpaRepository<SMSMessage, Long>{
	
}
