package com.DAO;

import java.util.List;

import com.entiadad.EDispositivo;

public interface Dispositivo {
	
	public EDispositivo buscarxID(int x);
	public List<EDispositivo> listarTodo();
	public boolean guardar(EDispositivo o);
	public boolean eliminar(int id);
	
	

}
