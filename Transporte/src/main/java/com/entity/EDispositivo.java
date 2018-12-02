package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dispositivo")
public class EDispositivo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
		return "EDispositivo [id=" + id + ", descripcion=" + descripcion + ", puerto=" + puerto + "]";
	}
	public EDispositivo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
