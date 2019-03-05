package com.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
//import com.utilidad.LocalDateTimeDeserializer;
//import com.utilidad.LocalDateTimeSerializer;



/*Never forget
 * If you want to use @Column(...), then use small-case letters always even though your actual DB column is in camel-case.
 * */
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "postulante")
public class EPostulante  {	
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
	int codpais;
	String direccion;
	String correo;
	String observacion;
//	@JsonDeserialize(using =LocalDateTimeDeserializer.class)
//	@JsonSerialize(using =LocalDateTimeSerializer.class)
	@JsonSerialize(using = ToStringSerializer.class) 
	LocalDateTime fecharegistro;
	String estado;
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
	public Date getFechanacimiento() {
		return fechanacimiento;
	}
	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}
	
	public LocalDateTime getFecharegistro() {
		return fecharegistro;
	}
	public void setFecharegistro(LocalDateTime fecharegistro) {
		this.fecharegistro = fecharegistro;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
