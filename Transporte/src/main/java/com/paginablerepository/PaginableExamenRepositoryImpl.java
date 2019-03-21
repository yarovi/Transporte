package com.paginablerepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.modeloDTO.modeloExamenDTO;
import com.entity.*;

public class PaginableExamenRepositoryImpl implements IPaginableExamenRepository {

	@PersistenceContext
    private  EntityManager em;
	@Override
	public Page<modeloExamenDTO> getallExamen() {
		// TODO Auto-generated method stub
		
		List<modeloExamenDTO> result =em.createQuery("SELECT e.id, t1.descripcion from EExamen e "
				+ "INNER JOIN ETipo t1 ON e.codlicencia = t1.tipoid "
				+ "WHERE e.defecto like :valor",modeloExamenDTO.class)
				.setMaxResults(4)
				.setFirstResult(0*4)
				.setParameter("valor", "%%")
				.getResultList();
		return new PageImpl<>(result);
	}

}
