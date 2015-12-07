package com.aldeamo.trainning;

import java.util.concurrent.atomic.AtomicLong;

public class ProcesadorSMS {
	

	private final static AtomicLong contador = new AtomicLong(1L);
	
	public MensajeSMS procesar(MensajeSMS sms) {
		
		// Si el mensaje va dirigido al servicio de chat, no envía mensaje de respuesta
		if(CodigosCortos.AMIGO_CHAT.equals( sms.getDestino() ) ){
			return null;
		}
			
		// Procesa un mensaje que vaya al otro código corto, es decir, a la inscripción de amigo
		sms.setId(contador.getAndIncrement());
		
		MensajeSMS respuesta = new MensajeSMS(
				CodigosCortos.AMIGO, 
				sms.getOrigen(), 
				sms.getContenido() + ", Bienvenido al servicio Amigo!");
		
		respuesta.setId( sms.getId() );
		
		return respuesta;
	}

}
