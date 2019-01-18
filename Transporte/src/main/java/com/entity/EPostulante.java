package com.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "postulante")
public class EPostulante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String CodDocuemnto;
	String NroDocumento;
	int CodSangre;
	int CodEstadoCivil;
	@Column(name="idpaisfko")
	int codigoPais;
	String nombre;
	String ApellidoPaterno;
	String ApellidoMaterno;
	Date FechaNacimiento;
	Date FechaRegistro;
	float Estatura;
	String Correo;
	String Sexo;
	public String getSexo() {
		return Sexo;
	}

	

	public int getCodigoPais() {
		return codigoPais;
	}



	public void setCodigoPais(int codigoPais) {
		this.codigoPais = codigoPais;
	}



	public void setSexo(String sexo) {
		Sexo = sexo;
	}
	//lista de elementos
//	@JsonIgnore
//	 List<ETipo> ListaTipoDocuemnto = new ArrayList<>();
//	@JsonIgnore
//	 List<ETipo> ListaGradoAcademico= new ArrayList<>();
//	@JsonIgnore
//	 List<ETipo> ListaEstadoCivil= new ArrayList<>();
	 
	//fin lista
	public EPostulante() {
		super();
		// TODO Auto-generated constructor stub
	}
	
//	@JsonIgnore
//	public List<ETipo> getListaTipoDocuemnto() {
//		return ListaTipoDocuemnto;
//	}
//	@JsonIgnore
//	public void setListaTipoDocuemnto(List<ETipo> listaTipoDocuemnto) {
//		ListaTipoDocuemnto = listaTipoDocuemnto;
//	}
//	@JsonIgnore
//	public List<ETipo> getListaGradoAcademico() {
//		return ListaGradoAcademico;
//	}
//	@JsonIgnore
//	public void setListaGradoAcademico(List<ETipo> listaGradoAcademico) {
//		ListaGradoAcademico = listaGradoAcademico;
//	}
//	@JsonIgnore
//	public List<ETipo> getListaEstadoCivil() {
//		return ListaEstadoCivil;
//	}
//	@JsonIgnore
//	public void setListaEstadoCivil(List<ETipo> listaEstadoCivil) {
//		ListaEstadoCivil = listaEstadoCivil;
//	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodDocuemnto() {
		return CodDocuemnto;
	}
	public void setCodDocuemnto(String codDocuemnto) {
		CodDocuemnto = codDocuemnto;
	}
	public String getNroDocumento() {
		return NroDocumento;
	}
	public void setNroDocumento(String nroDocumento) {
		NroDocumento = nroDocumento;
	}
	public int getCodSangre() {
		return CodSangre;
	}
	public void setCodSangre(int codSangre) {
		CodSangre = codSangre;
	}
	public int getCodEstadoCivil() {
		return CodEstadoCivil;
	}
	public void setCodEstadoCivil(int codEstadoCivil) {
		CodEstadoCivil = codEstadoCivil;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoPaterno() {
		return ApellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		ApellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return ApellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		ApellidoMaterno = apellidoMaterno;
	}
	public Date getFechaNacimiento() {
		return FechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}
	public Date getFechaRegistro() {
		return FechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		FechaRegistro = fechaRegistro;
	}
	public float getEstatura() {
		return Estatura;
	}
	public void setEstatura(float estatura) {
		Estatura = estatura;
	}
	public String getCorreo() {
		return Correo;
	}
	public void setCorreo(String correo) {
		Correo = correo;
	}
	
	
	
}
