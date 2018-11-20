package com.entiadad;

public class EDispositivo {

	int id;
	String descripcion;
	String puerto;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getPuerto() {
		return puerto;
	}
	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}
	public EDispositivo(int id, String descripcion, String puerto) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.puerto = puerto;
	}
	@Override
	public String toString() {
		return "Dispositivo [id=" + id + ", descripcion=" + descripcion + ", puerto=" + puerto + "]";
	}
	public EDispositivo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
