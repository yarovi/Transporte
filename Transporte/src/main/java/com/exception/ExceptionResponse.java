package com.exception;

import java.sql.Date;

public class ExceptionResponse {

	private Date tiempo;
	private  String mensaje;
	private String detalle;
	public Date getTiempo() {
		return tiempo;
	}
	public void setTiempo(Date tiempo) {
		this.tiempo = tiempo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public ExceptionResponse(Date tiempo, String mensaje, String detalle) {
		super();
		this.tiempo = tiempo;
		this.mensaje = mensaje;
		this.detalle = detalle;
	}
	@Override
	public String toString() {
		return "ExceptionResponse [tiempo=" + tiempo + ", mensaje=" + mensaje + ", detalle=" + detalle + "]";
	}
	
	
}
