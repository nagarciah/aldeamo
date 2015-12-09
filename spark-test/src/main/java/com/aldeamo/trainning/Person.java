package com.aldeamo.trainning;

public class Person {
	String nombre;
	int edad;
	boolean empleado;

	public Person(String nombre, int edad, boolean empleado) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.empleado = empleado;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public boolean isEmpleado() {
		return empleado;
	}
	public void setEmpleado(boolean empleado) {
		this.empleado = empleado;
	}
}
