package com.aldeamo.trainning.fifa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;

/**
 * Un servicio que produce excepciones de forma errática
 * con tiempos de latencia aleatorios
 *  
 * @author nelson
 *
 */
@Service
public class RandomFailuresService {
	
	@Autowired
	MetricRegistry registry;

	public String getData(){
		registry.meter("meter.ramdomFailureService").mark();
		Timer.Context timer = registry.timer("timer.ramdomFailureService").time();
		
		// Demora aleatoria
		long delay = Math.round((Math.random() * 5000)); // Demora entre 1 y 5 segundos
		
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			// Ignora la excepción. 
			// No se requiere controlarla para este ejemplo
		}
		
		timer.stop();
		
		
		// Resultado/excepción aleatoria con probabilidad de error del 30%
		double random = Math.random();
		if(random<0.15){
			// 15% de probabilidad de este error
			registry.counter("counter.ramdomFailureService.servicio-no-disponible").inc();
			throw new RuntimeException("El servicio externo no está disponible");
			
		}else if(random<0.30){ 
			// 15% de probabilidad de este error
			registry.counter("counter.ramdomFailureService.respuesta-invalida").inc();
			throw new RuntimeException("La respuesta del servicio externo no es válida");
		}
		
		return "Respuesta correcta del servicio externo (" + delay + "ms)";
	}
}
