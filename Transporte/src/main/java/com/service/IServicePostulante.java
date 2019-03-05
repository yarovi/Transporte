package com.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import com.entity.EPostulante;
import com.modeloDTO.modeloEvaluacionDTO;
import com.modeloDTO.modeloPostulanteDTO;

public interface IServicePostulante extends IGenericService<EPostulante> {

	List<EPostulante>buscarxParametro(String tipo,String valor);
	List<modeloPostulanteDTO> findPostulantetoExamen();//,int page,int size);
	Page<modeloEvaluacionDTO> findPostulantetoEvaluacion(@Param("valor")String valor, int page,int size);
	Page<modeloEvaluacionDTO> findPostulantetoEvaluacionxNroDocumento(@Param("valor")String valor, int page,int size);
}
