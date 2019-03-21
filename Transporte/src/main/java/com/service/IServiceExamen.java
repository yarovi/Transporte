package com.service;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import com.entity.EExamen;
import com.modeloDTO.modeloExamenDTO;

public interface IServiceExamen extends IGenericService<EExamen> {

	Page<modeloExamenDTO> findPostulantetoExamenxNombre(@Param("valor")String valor, int page,int size);
//	Page<modeloExamenDTO> findPaginatedCustomxDOC(@Param("valor")String valor, int page,int size);
}
