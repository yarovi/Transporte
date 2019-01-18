package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.entity.EPais;
import com.repository.PaisRepository;
@Service
public class PaisService<T> implements IGenericService<EPais> {

	@Autowired
	private PaisRepository paisRespository;
	@Override
	public EPais create(EPais entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EPais> readAll() {
		// TODO Auto-generated method stub
		return paisRespository.findAll();
	}

	@Override
	public EPais edit(EPais entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EPais delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EPais findItemxId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<EPais> findPaginated(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EPais> findItemCustom(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
