package com.aldeamo.trainning.fifa.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Jugador implements Serializable {

	private static final long serialVersionUID = -21306046516344503L;
	
	@Id
	@GeneratedValue
	Long id;
	
	@NotNull
	String nombre;
	
	@NotNull
	String paisOrigen;
	Date fechaNacimiento;
	String pasaporte;
	@NotNull
	String posicion;
	
	public Jugador(){
		// Requerido por JPA
	}

	
	public Jugador(Long id, String nombre, String paísDeOrigen, Date fechaNacimiento, String pasaporte) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.paisOrigen = paísDeOrigen;
		this.fechaNacimiento = fechaNacimiento;
		this.pasaporte = pasaporte;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPaisOrigen() {
		return paisOrigen;
	}
	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getPasaporte() {
		return pasaporte;
	}
	public void setPasaporte(String pasaporte) {
		this.pasaporte = pasaporte;
	}


	public String getPosicion() {
		return posicion;
	}


	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
}
