package com.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.entity.EPostulante;
import com.modeloDTO.modeloEvaluacionDTO;
import com.modeloDTO.modeloPostulanteDTO;
import com.repository.PostulanteRepository;
import com.service.IServicePostulante;
@Service
public class SercicePostulanteImpl implements IServicePostulante {

	@Autowired
	private PostulanteRepository postulanteRepository;
	@Override
	public EPostulante create(EPostulante entity) {
		// TODO Auto-generated method stub
		return postulanteRepository.save(entity);
	}

	@Override
	public List<EPostulante> readAll() {
		// TODO Auto-generated method stub
		return postulanteRepository.findAll();
	}

	@Override
	public EPostulante edit(EPostulante entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EPostulante delete(int id) {
		// TODO Auto-generated method stub
		postulanteRepository.delete(id);
		 return null;
	}

	@Override
	public EPostulante findItemxId(int id) {
		// TODO Auto-generated method stub
		return postulanteRepository.getOne(id);
	}

	@Override
	public Page<EPostulante> findPaginated(int page, int size) {
		// TODO Auto-generated method stub
		return postulanteRepository.findAll(new PageRequest(page , size));
	}

	@Override
	public List<EPostulante> findItemCustom(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<modeloPostulanteDTO> findPostulantetoExamen(){
		// TODO Auto-generated method stub
		List<modeloPostulanteDTO> lsttmp= postulanteRepository.findPostulantetoExamen();		 
		 return lsttmp;
	}

	@Override
	public Page<modeloEvaluacionDTO> findPostulantetoEvaluacion(String valor, int page, int size) {
		// TODO Auto-generated method stub
		return postulanteRepository.findPostulantetoEvaluacion(valor,new PageRequest(page,size));
	}

	@Override
	public Page<modeloEvaluacionDTO> findPostulantetoEvaluacionxNroDocumento(String valor, int page, int size) {
		// TODO Auto-generated method stub
		return postulanteRepository.findPostulantetoEvaluacionxNroDocumento(valor,new PageRequest(page,size));
	}

	@Override
	public Page<EPostulante> findPaginatedCustomxNombre(String valor, int page, int size) {
		// TODO Auto-generated method stub
		return postulanteRepository.findPaginatedCustomxNombre(valor, new PageRequest(page,size));
	}

	@Override
	public Page<EPostulante> findPaginatedCustomxDOC(String valor, int page, int size) {
		// TODO Auto-generated method stub
		return postulanteRepository.findPaginatedCustomxDOC(valor, new PageRequest(page,size));
	}
	

}
