package com.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.entity.EEmpresa;
import com.repository.EmpresaRepository;
import com.service.IServiceEmpresa;
@Service
public class ServiceEmpresaImpl implements IServiceEmpresa {

	@Autowired
	private EmpresaRepository empresaRepository;
	@Override
	public EEmpresa create(EEmpresa entity) {
		// TODO Auto-generated method stub
		return empresaRepository.save(entity);
	}

	@Override
	public List<EEmpresa> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EEmpresa edit(EEmpresa entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EEmpresa delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EEmpresa findItemxId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<EEmpresa> findPaginated(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EEmpresa> findItemCustom(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EEmpresa getinfoEmpresa() {
		// TODO Auto-generated method stub
		EEmpresa empresa= new EEmpresa();
		return empresa;
	}
	

}
