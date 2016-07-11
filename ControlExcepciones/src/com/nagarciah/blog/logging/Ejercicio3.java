package com.nagarciah.blog.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio3 {
	
	private static final Logger log = Logger.getLogger(Ejercicio3.class.getName());  
	
	public static void main(String[] args){
		log.info("Mensaje para el log");
		log.severe("Mensaje de error para el log");
	}
}
