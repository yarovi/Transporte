package com.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;

import com.entity.EDispositivo;

public interface IGenericService<T > {

	T create(T entity);
	List<T> readAll();
	T edit(T entity);
	T delete(int id);
	T findItemxId(int id );
	Page<T> findPaginated(final int page, final int size);
	List<T> findItemCustom(int id);
	
}
