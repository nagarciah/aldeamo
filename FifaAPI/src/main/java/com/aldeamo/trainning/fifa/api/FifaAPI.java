package com.aldeamo.trainning.fifa.api;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aldeamo.trainning.fifa.entity.Equipo;
import com.aldeamo.trainning.fifa.entity.Jugador;
import com.aldeamo.trainning.fifa.repository.EquipoRepository;
import com.aldeamo.trainning.fifa.repository.JugadorRepository;

@RestController("/api")
public class FifaAPI {

	@Autowired
	JugadorRepository jugadorRepository;
	
	@Autowired
	EquipoRepository equipoRepository;
	
	@RequestMapping(value="/jugador", method=RequestMethod.GET)
	public Collection<Jugador> consultarJugadores(@RequestParam(required=false) Integer cuantos){
		
		Collection<Jugador> jugadores = jugadorRepository.findAll();
		if(cuantos!=null && cuantos>0 && jugadores.size()>cuantos){
			return jugadorRepository.findAll().subList(0, cuantos);
		}
		
		return jugadores;
	}
	
	
	@RequestMapping(value="/jugador/{id}", method=RequestMethod.GET)
	public Jugador consultarJugadorPorId(@PathVariable Long id){
		return jugadorRepository.findOne(id);
	}
	
	
	@RequestMapping(value="/jugador", method=RequestMethod.POST)
	public void crearJugador(@RequestBody @Valid Jugador jugador){
		jugadorRepository.saveAndFlush(jugador);
	}
	
	@RequestMapping(value="/equipo", method=RequestMethod.GET)
	public Collection<Equipo> consultarEquipos(){
		return equipoRepository.findAll();
	}
}
