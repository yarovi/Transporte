package com.service;

import java.io.Serializable;
import java.util.List;

import com.entity.EDispositivo;

public interface IGenericService<T > {

	T createDispositivo(T entity);
	List<T> getAllDispositivo();
	T editDispositivo(T entity);
	T deleteDispositivo(int id);
	T findDispositivoxId(int id );
	
}
