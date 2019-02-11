package com.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import com.entity.ETipo;

public interface IServiceTipo extends IGenericService<ETipo> {

	<T> List<T> findBySubCategory(@Param("id")int midi);
	<T> List<T> findByCategory();
	Page<ETipo> findPageBySubCategoryEntity(@Param("miId")int midi, int page,int size);
}
