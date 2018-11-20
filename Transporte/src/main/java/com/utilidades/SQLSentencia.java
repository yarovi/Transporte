package com.utilidades;




public final class SQLSentencia {

	//dispositivo
	public static String sqlInsertDispositivo="insert into dispositivo (descripcion,puerto)values(?,?)";
	public static String sqlModificarDispositivo="update dispositivo set descripcion=?,puerto=? where id=?";	
	public static String sqlbuscarxIdDispositivo="select * from dispositivo where id=?";
	public static String sqlTododDispositivo="select * from dispositivo";
	public static String sqlEliminarDispositivo="delete  from dispositivo where id=";
	//empresa
	public static String sqlInsertEmpresa="insert into empresa(razonsocial,direccionempresa,telefonoempresa,logoempresa)values(?,?,?,?)";
	public static String sqlbuscarxIdEmpresa="select * from empresa where idempresa=?";
	public static String sqlTododEmpresa="select * from empresa";
	public static String sqlEliminarEmpresa="delete  from empresa where idempresa=?";
	
	
	
	
	
}
