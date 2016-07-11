package com.nagarciah.blog.logging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Ejercicio5 {
	
	private static final Log log = LogFactory.getLog(Ejercicio5.class);  
	
	public static void main(String[] args){
		log.fatal("Mensaje de error fatal");
		log.error("Mensaje de error error");
		log.warn("Mensaje de error warn");
		log.info("Mensaje de error info");
		log.debug("Mensaje de error debug");
		log.trace("Mensaje de error trace");
	}
}
