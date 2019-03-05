package com.modeloDTO;

public class modeloEvaluacionDTO {

	int id;
	String NroDocumento;
	String nombres;
	int Edad;
	String Sexo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNroDocumento() {
		return NroDocumento;
	}
	public void setNroDocumento(String nroDocumento) {
		NroDocumento = nroDocumento;
	}
	
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public int getEdad() {
		return Edad;
	}
	public void setEdad(int edad) {
		Edad = edad;
	}
	public String getSexo() {
		return Sexo;
	}
	public void setSexo(String sexo) {
		Sexo = sexo;
	}
	public modeloEvaluacionDTO(int id, String nroDocumento, String nombres, int edad, String sexo) {
		super();
		this.id = id;
		NroDocumento = nroDocumento;
		this.nombres = nombres;
		Edad = edad;
		Sexo = sexo;
	}
	
	
}
