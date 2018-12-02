package com.entity;

import java.util.Arrays;

public class EEmpresa {

	int diempresa;
	String razonsocial;
	String direccionempresa;
	int telefonoempresa;
	byte[] imagenempresa;
	public int getDiempresa() {
		return diempresa;
	}
	public void setDiempresa(int diempresa) {
		this.diempresa = diempresa;
	}
	public String getRazonsocial() {
		return razonsocial;
	}
	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}
	public String getDireccionempresa() {
		return direccionempresa;
	}
	public void setDireccionempresa(String direccionempresa) {
		this.direccionempresa = direccionempresa;
	}
	public int getTelefonoempresa() {
		return telefonoempresa;
	}
	public void setTelefonoempresa(int telefonoempresa) {
		this.telefonoempresa = telefonoempresa;
	}
	public byte[] getImagenempresa() {
		return imagenempresa;
	}
	public void setImagenempresa(byte[] imagenempresa) {
		this.imagenempresa = imagenempresa;
	}
	public EEmpresa(int diempresa, String razonsocial, String direccionempresa, int telefonoempresa,
			byte[] imagenempresa) {
		super();
		this.diempresa = diempresa;
		this.razonsocial = razonsocial;
		this.direccionempresa = direccionempresa;
		this.telefonoempresa = telefonoempresa;
		this.imagenempresa = imagenempresa;
	}
	public EEmpresa() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Empresa [diempresa=" + diempresa + ", razonsocial=" + razonsocial + ", direccionempresa="
				+ direccionempresa + ", telefonoempresa=" + telefonoempresa + ", imagenempresa="
				+ Arrays.toString(imagenempresa) + "]";
	}
	
	
}
