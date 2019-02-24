package com.modeloDTO;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class modeloPostulanteDTO {

	int id;
	String Codigo;
//	String fechaRegistro;
	LocalDateTime registro;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodigo() {
		return Codigo;
	}
	public void setCodigo(String codigo) {
		Codigo = codigo;
	}
//	public String getFechaRegistro() {
//		return fechaRegistro;
//	}
//	public void setFechaRegistro(String fechaRegistro) {
//		this.fechaRegistro = fechaRegistro;
//	}
	@JsonSerialize(using = ToStringSerializer.class) 
	public LocalDateTime getFecha() {
		return registro;
	}
	public void setFecha(LocalDateTime fecha) {
		this.registro = fecha;
	}
	public modeloPostulanteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
//	public modeloPostulanteDTO(int id, String codigo, String fechaRegistro) {
//		this.id = id;
//		Codigo = codigo;
//		this.fechaRegistro=fechaRegistro;
//	}
	public modeloPostulanteDTO(int id, String codigo, LocalDateTime fecha) {
		super();
		this.id = id;
		Codigo = codigo;
		this.registro = fecha;
	}
	
	
}
