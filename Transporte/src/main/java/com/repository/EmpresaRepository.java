package com.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.entity.EEmpresa;

public interface EmpresaRepository extends JpaRepository<EEmpresa, Integer> {

	@Modifying
	@Transactional
	@Query("update EEmpresa set logo = :img where id = :id")
	int updateLogo(@Param("id")int id,@Param("img")byte [] img);
}
