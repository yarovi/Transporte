package com.service;

import org.springframework.data.repository.query.Param;

import com.entity.EEmpresa;

public interface IServiceEmpresa extends IGenericService<EEmpresa> {

	EEmpresa getinfoEmpresa();
	int  updateLogo(@Param("id") int id,@Param("img") byte [] img);
}
