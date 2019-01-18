package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.entity.*;
import com.repository.DispositivoRepository;


@Service
public class DispositivoService<T> implements IGenericService<EDispositivo>  {

	@Autowired
	private DispositivoRepository dispositivoRepository;

	@Override
	public EDispositivo create(EDispositivo entity) {
		
		return dispositivoRepository.save(entity);
	}

	@Override
	public List<EDispositivo> readAll() {
		// TODO Auto-generated method stub
		return dispositivoRepository.findAll();
	}

	@Override
	public EDispositivo edit(EDispositivo entity) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public EDispositivo findItemxId(int id) {
		// TODO Auto-generated method stub
		return dispositivoRepository.getOne(id);
	}

	@Override
	public EDispositivo delete(int id) {
		dispositivoRepository.delete(id);
		return null;
	}
//	public Page<EDispositivo> findPaginated(int page, int size){
//		return dispositivoRepository.findAll(new PageRequest(page,size));
//	}

	@Override
	public Page<EDispositivo> findPaginated(int page, int size) {
		return dispositivoRepository.findAll(new PageRequest(page,size));
		//return null;
	}

	@Override
	public List<EDispositivo> findItemCustom(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
