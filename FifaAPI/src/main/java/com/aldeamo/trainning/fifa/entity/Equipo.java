package com.aldeamo.trainning.fifa.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Equipo implements Serializable{

	private static final long serialVersionUID = 6758888449675150123L;
	
	@Id
	@GeneratedValue
	Long id;
	String nombre;
	String pais;
	@OneToMany()
	Collection<Jugador> jugadores;
	
	public Equipo(){
		// Requerido por JPA
	}
	
	public Equipo(String nombre, String pais, Collection<Jugador> jugadores) {
		super();
		this.nombre = nombre;
		this.pais = pais;
		this.jugadores = jugadores;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public Collection<Jugador> getJugadores() {
		return jugadores;
	}
	public void setJugadores(Collection<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
