package com.DAO;

import static org.mockito.Matchers.intThat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entiadad.EDispositivo;
import com.utilidades.ConectorDB;
import com.utilidades.SQLSentencia;

public class DispositivoImpl implements Dispositivo {

	private static Connection con;

	@Override
	public EDispositivo buscarxID(int x) {
		// TODO Auto-generated method stub
		con = ConectorDB.getConectorDB();
		EDispositivo dispositivo=null;
		try 
		{
			Statement st =con.createStatement();
			PreparedStatement ps=con.prepareStatement(SQLSentencia.sqlbuscarxIdDispositivo);
			ps.setInt(1, x);
			ResultSet rst=ps.executeQuery();				
			if(rst.next()) {				
				dispositivo =new EDispositivo(rst.getInt(1),rst.getString(2),rst.getString(3));
			}
			rst.close();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return dispositivo;
	}

	@Override
	public List<EDispositivo> listarTodo() {
		// TODO Auto-generated method stub
		List<EDispositivo > listaDispositivo= new ArrayList<>();
		con = ConectorDB.getConectorDB();
		try 
		{
			Statement st =con.createStatement();
			ResultSet rst= st.executeQuery(SQLSentencia.sqlTododDispositivo);
			
			EDispositivo dispositivo;
			
			while(rst.next()) {
				
				dispositivo =new EDispositivo(rst.getInt(1),rst.getString(2),rst.getString(3));
				listaDispositivo.add(dispositivo);
			}
			rst.close();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return listaDispositivo;
	}

	@Override
	public boolean guardar(EDispositivo o) {
		// TODO Auto-generated method stub
		con = ConectorDB.getConectorDB();
		try {
			if (o.getId() == 0) {
				PreparedStatement ps = con.prepareStatement(SQLSentencia.sqlInsertDispositivo);
				ps.setString(1, o.getDescripcion());
				ps.setString(2, o.getPuerto());
				int r = ps.executeUpdate();
				if (r > 0)
					return true;
				ps.close();
				con.close();
			}

		} catch (SQLException e) {
			// TODO: handle exception

			System.out.println(" error insertando " + e.getMessage());
		}

		return false;
	}

	@Override
	public boolean eliminar(int id) {
		// TODO Auto-generated method stub
		
		con=ConectorDB.getConectorDB();
		try {
			
			Statement st = con.createStatement();
			int r= st.executeUpdate(SQLSentencia.sqlEliminarDispositivo + id);
			
			if(r>0)
				return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(" error eliminando " + e.getMessage());
		}
		
		
		return false;
	}

}
