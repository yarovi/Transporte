package com.paginablerepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.entity.EExamen;
import com.modeloDTO.modeloExamenDTO;

public interface PaginableExamenRepository extends PagingAndSortingRepository<EExamen, Integer>,IPaginableExamenRepository {

	
}
