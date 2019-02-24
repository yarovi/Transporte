package com.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.entity.ETipo;
import com.modeloDTO.modelTipoDTO;
import com.repository.TipoRepository;
import com.service.IServiceTipo;
@Service
public class ServiceTipoImpl implements IServiceTipo {

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
		tipoRepository.delete(id);
		return null;
	}

	@Override
	public ETipo findItemxId(int id) {
		// TODO Auto-generated method stub
		return tipoRepository.findOne(id);
	}

	@Override
	public Page<ETipo> findPaginated(int page, int size) {
		// TODO Auto-generated method stub
		return tipoRepository.findPageByCategoryEntity(new PageRequest(page,size));
	}

	@Override
	public List<ETipo> findItemCustom(int id) {
		// TODO Auto-generated method stub
		return null;// tipoRepository.find;
	}

	@Override
	public List<modelTipoDTO> findBySubCategory(int midi) {
		// TODO Auto-generated method stub
		return tipoRepository.findBySubCategory(midi);
	}

	@Override
	public List<modelTipoDTO> findByCategory() {
		// TODO Auto-generated method stub
		
		return tipoRepository.findByCategory();
	}

	@Override
	public Page<ETipo> findPageBySubCategoryEntity(int midi,int page,int size) {
		// TODO Auto-generated method stub
		return tipoRepository.findPageBySubCategoryEntity(midi,new PageRequest(page,size) );
	}

}
