package com.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.entity.EExamen;
import com.repository.ExamenRepository;
import com.service.IServiceExamen;
@Service
public class ServiceExamenImpl implements IServiceExamen {

	@Autowired
	private ExamenRepository examenRepository;
	@Override
	public EExamen create(EExamen entity) {
		// TODO Auto-generated method stub
		return examenRepository.save(entity);
	}

	@Override
	public List<EExamen> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EExamen edit(EExamen entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EExamen delete(int id) {
		// TODO Auto-generated method stub
		 examenRepository.delete(id);
		 return null;
	}

	@Override
	public EExamen findItemxId(int id) {
		// TODO Auto-generated method stub
		return examenRepository.findOne(id);
	}

	@Override
	public Page<EExamen> findPaginated(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EExamen> findItemCustom(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
