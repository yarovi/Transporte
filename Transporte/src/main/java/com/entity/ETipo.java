package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo")
public class ETipo  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int tipoid;
	@Column(name="codtipo")
	String codtipo;
	@Column(name="parent_idtipo")
	int parent_idtipo;
	@Column(name="referencia")
	String referencia;
	@Column(name="descripcion")
	String descripcion;
	public int getTipoid() {
		return tipoid;
	}
	public void setTipoid(int tipoid) {
		this.tipoid = tipoid;
	}

	public void setCodtipo(String codtipo) {
		this.codtipo = codtipo;
	}

	public void setParent_idtipo(int parent_idtipo) {
		this.parent_idtipo = parent_idtipo;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
	
	public ETipo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ETipo [tipoid=" + tipoid + ", referencia=" + referencia + "]";
	}
public ETipo(int tipoid, String descripcion) {
	super();
	this.tipoid = tipoid;
	this.descripcion = descripcion;
}
	
	
	
	
}
