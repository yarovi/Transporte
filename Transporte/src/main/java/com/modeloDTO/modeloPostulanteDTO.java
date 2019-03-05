package com.modeloDTO;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
//import com.utilidad.LocalDateTimeDeserializer;
//import com.utilidad.LocalDateTimeSerializer;

public class modeloPostulanteDTO {

	int id;
	String nombres;
//	@JsonDeserialize(using =LocalDateTimeDeserializer.class)
//	@JsonSerialize(using =LocalDateTimeSerializer.class)
	@JsonSerialize(using = ToStringSerializer.class) 
	LocalDateTime fecha;	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public modeloPostulanteDTO(int id, String codigo, LocalDateTime fecharegistro) {
		super();
		this.id = id;
		this.nombres = codigo;
		this.fecha = fecharegistro;
	}
	public modeloPostulanteDTO(int id, String codigo) {
		super();
		this.id = id;
		this.nombres = codigo;
//		this.fecharegistro = fecha;
	}
		
}
