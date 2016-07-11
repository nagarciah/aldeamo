package com.nagarciah.blog.logging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Ejercicio7 {
	
	private static final Log log = LogFactory.getLog(Ejercicio7.class);  
	
	public static void main(String[] args){
		long a = 0;
		long b = 10;

		try{
			dividir(a, b);
		}catch(Exception e){
			System.out.println("Señor usuario, los datos que ha ingresado no son correctos y han causado un error en la aplicación: a=" + a + ", b=" + b);
			log.error("Ha ocurrido ejecutando la división:",  e);
			log.error("parámetros: a= " + a + ",b=" + b);
		}
	}

	private static long dividir(long a, long b) throws Exception {
		return b/a;
	}
}
