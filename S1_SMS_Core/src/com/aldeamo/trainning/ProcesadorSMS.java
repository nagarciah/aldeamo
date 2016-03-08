package com.aldeamo.trainning;

import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.validator.routines.LongValidator;

public class ProcesadorSMS {
	

	private final static AtomicLong contador = new AtomicLong(1L);
	
	public MensajeSMS procesar(MensajeSMS sms) {
		
		// Si el mensaje va dirigido al servicio de chat, no envía mensaje de respuesta
		if(CodigosCortos.AMIGO.equals( sms.getDestino() ) ){
			return procesarAmigo(sms );
		}else{
			return procesarSMSi(sms); 
		}
	}

	
	private MensajeSMS procesarAmigo(MensajeSMS sms) {
		// Procesa un mensaje que vaya al otro código corto, es decir, a la inscripción de amigo
		sms.setId(contador.getAndIncrement());
		
		MensajeSMS respuesta = new MensajeSMS(
				CodigosCortos.AMIGO, 
				sms.getOrigen(), 
				sms.getContenido() + ", Bienvenido al servicio Amigo!");
		
		respuesta.setId( sms.getId() );
		
		return respuesta;
	}


	private MensajeSMS procesarSMSi(MensajeSMS sms) {
		// Procesa un mensaje que vaya al otro código corto, es decir, a la inscripción de amigo
		sms.setId(contador.getAndIncrement());
		
		MensajeSMS respuesta = new MensajeSMS();
		
		respuesta.setId( sms.getId() );
		
		boolean isNumeric = LongValidator.getInstance().isValid(sms.getDestino()); 

		if(isNumeric){
			respuesta.setEstado( "recibido" );
		}else{
			respuesta.setEstado( "rechazado porque el número no es un número válido" );
		}
			
		
		
		return respuesta;
	}
}
