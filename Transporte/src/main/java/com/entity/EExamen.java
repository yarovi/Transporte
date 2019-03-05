package com.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "examen")public class EExamen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column(name="postulante_id")
	int codpostulante;
	@Column(name="donante")
	String donante;
	@Column(name="codrestriccion")
	int codretriccion;
	@Column(name="codlicencia")
	int codlicencia;
	@Column(name="codcategoria")
	int codcategoria;
	@Column(name="codactitud")
	int codactitud;
	@Column(name="codcomportamiento")
	int codcomportamiento;	
	@Column(name="codenfermedad")
	int codenfermedad;
	@Column(name="codsangre")
	int codsangre;
	@Column(name="observacion")
	String observacion;
	@Column(name="defecto")
	String defecto;
	@Column(name="exadroga")
	Boolean examenDro;
	@Column(name="examarihuana")
	Boolean examenMari;
	@Column(name="exalcohol")
	Boolean examenAlc;
	@Column(name="estado")
	String estado;
	@Column(name="fregistro")
	Date fecharegistro;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCodpostulante() {
		return codpostulante;
	}
	public void setCodpostulante(int codpostulante) {
		this.codpostulante = codpostulante;
	}
	public String getDonante() {
		return donante;
	}
	public void setDonante(String donante) {
		this.donante = donante;
	}
	public int getCodretriccion() {
		return codretriccion;
	}
	public void setCodretriccion(int codretriccion) {
		this.codretriccion = codretriccion;
	}
	public int getCodlicencia() {
		return codlicencia;
	}
	public void setCodlicencia(int codlicencia) {
		this.codlicencia = codlicencia;
	}
	public int getCodcategoria() {
		return codcategoria;
	}
	public void setCodcategoria(int codcategoria) {
		this.codcategoria = codcategoria;
	}
	public int getCodactitud() {
		return codactitud;
	}
	public void setCodactitud(int codactitud) {
		this.codactitud = codactitud;
	}
	public int getCodcomportamiento() {
		return codcomportamiento;
	}
	public void setCodcomportamiento(int codcomportamiento) {
		this.codcomportamiento = codcomportamiento;
	}
	public int getCodenfermedad() {
		return codenfermedad;
	}
	public void setCodenfermedad(int codenfermedad) {
		this.codenfermedad = codenfermedad;
	}
	public int getCodsangre() {
		return codsangre;
	}
	public void setCodsangre(int codsangre) {
		this.codsangre = codsangre;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public String getDefecto() {
		return defecto;
	}
	public void setDefecto(String defecto) {
		this.defecto = defecto;
	}
	public Boolean getExamenDro() {
		return examenDro;
	}
	public void setExamenDro(Boolean examenDro) {
		this.examenDro = examenDro;
	}
	public Boolean getExamenMari() {
		return examenMari;
	}
	public void setExamenMari(Boolean examenMari) {
		this.examenMari = examenMari;
	}
	public Boolean getExamenAlc() {
		return examenAlc;
	}
	public void setExamenAlc(Boolean examenAlc) {
		this.examenAlc = examenAlc;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getFecharegistro() {
		return fecharegistro;
	}
	public void setFecharegistro(Date fecharegistro) {
		this.fecharegistro = fecharegistro;
	}
}
