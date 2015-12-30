package com.aldeamo.core.processor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.aldeamo.core.model.SMSMessage;

@Component
public interface SMSMessageRepository extends JpaRepository<SMSMessage, Long>{
	
}
