package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.entity.ETipo;
import com.repository.TipoRepository;

@Service
public class TipoService<T> implements IGenericService<ETipo> {

	@Autowired
	private TipoRepository tipoRepository;

	@Override
	public ETipo create(ETipo entity) {
		// TODO Auto-generated method stub
		return tipoRepository.save(entity);
	}

	@Override
	public List<ETipo> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ETipo edit(ETipo entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ETipo delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ETipo findItemxId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ETipo> findPaginated(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ETipo> findItemCustom(int id) {
		// TODO Auto-generated method stub
		return tipoRepository.findByTipoParent(id);
	}
	
	



}
