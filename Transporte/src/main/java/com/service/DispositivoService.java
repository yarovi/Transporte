package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.EDispositivo;
import com.repository.DispositivoRepository;


@Service
public class DispositivoService<T> implements IGenericService<EDispositivo>  {

	@Autowired
	private DispositivoRepository dispositivoRepository;

	@Override
	public EDispositivo createDispositivo(EDispositivo entity) {
		
		return dispositivoRepository.save(entity);
	}

	@Override
	public List<EDispositivo> getAllDispositivo() {
		// TODO Auto-generated method stub
		return dispositivoRepository.findAll();
	}

	@Override
	public EDispositivo editDispositivo(EDispositivo entity) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public EDispositivo findDispositivoxId(int id) {
		// TODO Auto-generated method stub
		return dispositivoRepository.getOne(id);
	}

	@Override
	public EDispositivo deleteDispositivo(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
