package com.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.entity.ETipo;
import com.modeloDTO.modelTipoDTO;


public interface TipoRepository extends JpaRepository<ETipo,Integer> {

	@Query("select new  com.modeloDTO.modelTipoDTO(t.tipoid ,t.descripcion) from ETipo  t where t.parent_idtipo = :id")
	List<modelTipoDTO> findBySubCategory(@Param("id")int midi);
	@Query("select new com.modeloDTO.modelTipoDTO(tt.tipoid ,tt.descripcion) from ETipo  tt where tt.parent_idtipo IS NULL")
	List<modelTipoDTO> findByCategory();
	//retornan data para paginar
	@Query("select tt from ETipo  tt where tt.parent_idtipo IS NULL")
	Page<ETipo> findPageByCategoryEntity(Pageable pageable);
	@Query("select tt from ETipo  tt  where tt.parent_idtipo = :miId")
	Page<ETipo> findPageBySubCategoryEntity(@Param("miId") int midi,Pageable pageable);
}
