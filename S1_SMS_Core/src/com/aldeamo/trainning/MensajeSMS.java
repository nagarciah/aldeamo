package com.aldeamo.trainning;

public class MensajeSMS {

	long id;
	String origen;
	String destino;
	String contenido;
	String estado;
	
	public MensajeSMS(String origen, String destino, String contenido) {
		this.origen = origen;
		this.destino = destino;
		this.contenido = contenido;
	}

	public MensajeSMS() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MensajeSMS [id=").append(id).append(", origen=").append(origen).append(", destino=")
				.append(destino).append(", contenido=").append(contenido).append(", estado=").append(estado)
				.append("]");
		return builder.toString();
	}
}
