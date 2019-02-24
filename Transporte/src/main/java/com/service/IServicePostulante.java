package com.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.entity.EPostulante;
import com.modeloDTO.modeloPostulanteDTO;

public interface IServicePostulante extends IGenericService<EPostulante> {

	List<EPostulante>buscarxParametro(String tipo,String valor);
	List<modeloPostulanteDTO> findPostulantetoExamen();//,int page,int size);
}
