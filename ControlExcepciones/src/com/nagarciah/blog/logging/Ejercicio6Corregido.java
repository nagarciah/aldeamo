package com.nagarciah.blog.logging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Ejercicio6Corregido {
	
	private static final Log log = LogFactory.getLog(Ejercicio6Corregido.class);  
	
	public static void main(String[] args){
		long a = 0;
		long b = 10;
		
		try{
			dividir(a, b);
		}catch(Exception e){
			log.error("Ha ocurrido un error:",  e);
		}
	}

	private static long dividir(long a, long b) throws Exception {
		try{
			return b/a;
		}catch(Exception e){
			throw new Exception("Error interno", e);
		}
	}
}
