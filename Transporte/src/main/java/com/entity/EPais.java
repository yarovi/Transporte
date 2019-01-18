package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pais")
public class EPais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String nombre;
	public int getId() {
		return id;
	}
	public void setId(int idpais) {
		this.id = idpais;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombrepais) {
		this.nombre = nombrepais;
	}
	
	
}
