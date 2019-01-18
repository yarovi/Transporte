package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.ETipo;

@Repository
public interface TipoRepository extends JpaRepository<ETipo,Integer> {

	@Query("select new ETipo(t.tipoid ,t.descripcion) from ETipo  t where t.parent_idtipo = :id")
	//@Query("select t from ETipo  t where t.parent_idtipo = :id")
	List<ETipo> findByTipoParent(@Param("id")int midi);
}
