package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "tipo")
public class ETipo  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int tipoid;
	@Column(name="codtipo")
	String codtipo;
	@Column(name="parent_idtipo",nullable=true)
	Integer parent_idtipo;
	@Column(name="referencia")
	String referencia;
	@Size(min = 3, message = "El campo descripcion debe estar lleno ")
	@Column(name="descripcion",nullable=false,length=20)
	String descripcion;
	public int getTipoid() {
		return tipoid;
	}
	public void setTipoid(int tipoid) {
		this.tipoid = tipoid;
	}
	public String getCodtipo() {
		return codtipo;
	}
	public void setCodtipo(String codtipo) {
		this.codtipo = codtipo;
	}
	public Integer getParent_idtipo() {
		return parent_idtipo;
	}
	public void setParent_idtipo(Integer parent_idtipo) {
		this.parent_idtipo = parent_idtipo;
	}
	public String getReferencia() {
		return referencia;
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
	@Override
	public String toString() {
		return "ETipo [tipoid=" + tipoid + ", codtipo=" + codtipo + ", parent_idtipo=" + parent_idtipo + ", referencia="
				+ referencia + ", descripcion=" + descripcion + "]";
	}	
	
	

	
	
}
