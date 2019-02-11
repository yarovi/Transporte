package com.modeloDTO;

import org.springframework.beans.factory.annotation.Value;


public class modelTipoDTO {

	private int id;
	private String descripcion;
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
	public modelTipoDTO(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}
	
}
