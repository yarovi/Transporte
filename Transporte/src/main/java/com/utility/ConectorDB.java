package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectorDB {

	private static Connection conn=null;
	private String driver;
	private String url;
	private String usuario;
	
	private String contrasena;
	private ConectorDB() {
		
		url="jdbc:mysql://localhost:3306/TransporteDB";
		driver="com.mysql.jdbc.Driver";
		usuario="root";
		contrasena="2006702231";
		
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, usuario, contrasena);
		}catch (Exception e) {
			System.out.println("Error Conectando :"+e.getMessage());
		}
		
	}
	
	
	public static Connection getConectorDB() {
		if (conn==null)
			new ConectorDB();
		
		return conn;
	} 
	
}
