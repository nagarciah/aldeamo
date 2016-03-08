package com.aldeamo.trainning.fifa.monitoring;

import java.util.Date;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;

//@ManagedResource(value="Ejemplo de monitor JMX", description="Es solo un ejemplo con Boot")
public class JMXFifaMonitor {

	//@ManagedAttribute
	public String anyValue(){
		return "My value " + new Date().toString();
	}
}
