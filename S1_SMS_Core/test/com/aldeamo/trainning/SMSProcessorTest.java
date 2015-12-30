package com.aldeamo.trainning;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.apache.commons.validator.routines.LongValidator;
import org.junit.Test;

public class SMSProcessorTest {

	/**
	 * Prueba que el sistema responde con un saludo cuando recibe un mensaje
	 * con el nombre del usuario al código corto de Amigo
	 */
	@Test
	public void inscribirAmigo() {
		// Arrange
		String gsmOrigen = "3001111111";
		ProcesadorSMS procesador = new ProcesadorSMS();
		MensajeSMS sms = new MensajeSMS(
				gsmOrigen, CodigosCortos.AMIGO, "Maynard"); 
		
		// Act
		MensajeSMS respuesta = procesador.procesar(sms);
		
		// Assert
		assertEquals(
				"Respuesta de inscripción a Amigo", 
				"Maynard, Bienvenido al servicio Amigo!", 
				respuesta.getContenido());
		
		assertEquals(
				"Codigo de origen", 
				CodigosCortos.AMIGO, 
				respuesta.getOrigen());
		
		assertEquals(
				"Número de destino", 
				gsmOrigen, 
				respuesta.getDestino());
		
		assertNotEquals("Id generado", 0, sms.getId());
	}
	
	
	/**
	 * Prueba que el sistema recibe un mensaje del usuario
	 */
	@Test
	public void enviarSMS(){
		// Arrange
		String gsmOrigen = "544";
		String gsmDestino = "3101111111";
		
		ProcesadorSMS procesador = new ProcesadorSMS();
		MensajeSMS sms = new MensajeSMS(
				gsmOrigen, gsmDestino, "Usted ha retirado $200.000, Chicó Norte."); 
		
		// Act
		MensajeSMS respuesta = procesador.procesar(sms);
		
		// Assert
		assertEquals(
				"Respuesta de mensaje SMS", 
				"recibido", 
				respuesta.getEstado());
		
		assertNotEquals(
				"Id generado", 
				0, 
				sms.getId());
	}
	
	
	/**
	 * Prueba la respuesta del envío a un número no válido
	 */
	@Test
	public void enviarSMSNumeroInvalido(){
		// Arrange
		String gsmOrigen = "abcdef";
		String gsmDestino = "abcdef";
		ProcesadorSMS procesador = new ProcesadorSMS();
		MensajeSMS sms = new MensajeSMS(
				gsmOrigen, gsmDestino, "Usted ha retirado $200.000, Chicó Norte."); 
		
		// Act
		MensajeSMS respuesta = procesador.procesar(sms);
		
		// Assert
		assertEquals(
				"Respuesta de mensaje SMS", 
				"rechazado porque el número no es un número válido", 
				respuesta.getEstado());
		
		assertNotEquals(
				"Id generado", 
				0, 
				sms.getId());
	}
}
