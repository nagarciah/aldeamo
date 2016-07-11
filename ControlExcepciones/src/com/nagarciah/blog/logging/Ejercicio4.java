package com.nagarciah.blog.logging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Ejercicio4 {
	
	private static final Log log = LogFactory.getLog(Ejercicio4.class);  
	
	public static void main(String[] args){
		log.info("Mensaje para el log");

		// Nótese el cambio en el nombre del método severe por error. 
		// Es una forma de estandarizar el nombre del método entre 
		// diferentes implementaciones de log
		log.error("Mensaje de error para el log"); 
	}
}
