package com.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "postulante")
public class EPostulante implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String apellidopaterno;
	String apellidomaterno;
	String nombre;
	int coddocumento;
	String nrodocumento;
	Date fechanacimiento;
	int edad;
	String sexo;
	int codgrado;
	int codestadocivil;
	@Column(name="idpaisfk")
	int codpais;
	String direccion;
	String correo;
	String observacion;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getApellidopaterno() {
		return apellidopaterno;
	}
	public void setApellidopaterno(String apellidopaterno) {
		this.apellidopaterno = apellidopaterno;
	}
	public String getApellidomaterno() {
		return apellidomaterno;
	}
	public void setApellidomaterno(String apellidomaterno) {
		this.apellidomaterno = apellidomaterno;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCoddocumento() {
		return coddocumento;
	}
	public void setCoddocumento(int coddocumento) {
		this.coddocumento = coddocumento;
	}
	public String getNrodocumento() {
		return nrodocumento;
	}
	public void setNrodocumento(String nrodocumento) {
		this.nrodocumento = nrodocumento;
	}
	public Date getFechanacimiento() {
		return fechanacimiento;
	}
	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public int getCodgrado() {
		return codgrado;
	}
	public void setCodgrado(int codgrado) {
		this.codgrado = codgrado;
	}
	public int getCodestadocivil() {
		return codestadocivil;
	}
	public void setCodestadocivil(int codestadocivil) {
		this.codestadocivil = codestadocivil;
	}
	public int getCodpais() {
		return codpais;
	}
	public void setCodpais(int codpais) {
		this.codpais = codpais;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	@Override
	public String toString() {
		return "EPostulante [id=" + id + ", apellidopaterno=" + apellidopaterno + ", apellidomaterno=" + apellidomaterno
				+ ", nombre=" + nombre + ", coddocumento=" + coddocumento + ", nrodocumento=" + nrodocumento
				+ ", fechanacimiento=" + fechanacimiento + ", edad=" + edad + ", sexo=" + sexo + ", codgrado="
				+ codgrado + ", codestadocivil=" + codestadocivil + ", codpais=" + codpais + ", direccion=" + direccion
				+ ", correo=" + correo + ", observacion=" + observacion + "]";
	}
	
	
	
	



	
	
	
	
}
