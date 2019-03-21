package com.paginablerepository;

import org.springframework.data.domain.Page;

import com.modeloDTO.modeloExamenDTO;

public interface IPaginableExamenRepository {

	Page<modeloExamenDTO>getallExamen();
}
