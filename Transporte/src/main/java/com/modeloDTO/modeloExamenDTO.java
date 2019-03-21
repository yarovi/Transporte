package com.modeloDTO;

public class modeloExamenDTO {

	int id;
	String descripcionLicencia;
	String descripcionCategoria;
	String descripcionActitud;
	String descripcionComportamiento;
	String descripcionSangre;
	String nombrePostulante;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcionLicencia() {
		return descripcionLicencia;
	}
	public void setDescripcionLicencia(String descripcionLicencia) {
		this.descripcionLicencia = descripcionLicencia;
	}
	public String getDescripcionCategoria() {
		return descripcionCategoria;
	}
	public void setDescripcionCategoria(String descripcionCategoria) {
		this.descripcionCategoria = descripcionCategoria;
	}
	public String getDescripcionActitud() {
		return descripcionActitud;
	}
	public void setDescripcionActitud(String descripcionActitud) {
		this.descripcionActitud = descripcionActitud;
	}
	public String getDescripcionComportamiento() {
		return descripcionComportamiento;
	}
	public void setDescripcionComportamiento(String descripcionComportamiento) {
		this.descripcionComportamiento = descripcionComportamiento;
	}
	public String getDescripcionSangre() {
		return descripcionSangre;
	}
	public void setDescripcionSangre(String descripcionSangre) {
		this.descripcionSangre = descripcionSangre;
	}
	public String getNombrePostulante() {
		return nombrePostulante;
	}
	public void setNombrePostulante(String nombrePostulante) {
		this.nombrePostulante = nombrePostulante;
	}
	public modeloExamenDTO(int id, String descripcionLicencia, String descripcionCategoria, String descripcionActitud,
			String descripcionComportamiento, String descripcionSangre, String nombrePostulante) {
		super();
		this.id = id;
		this.descripcionLicencia = descripcionLicencia;
		this.descripcionCategoria = descripcionCategoria;
		this.descripcionActitud = descripcionActitud;
		this.descripcionComportamiento = descripcionComportamiento;
		this.descripcionSangre = descripcionSangre;
		this.nombrePostulante = nombrePostulante;
	}
	public modeloExamenDTO(int id, String descripcionLicencia) {
		super();
		this.id = id;
		this.descripcionLicencia = descripcionLicencia;
	}
	
	
	
	
	
}
