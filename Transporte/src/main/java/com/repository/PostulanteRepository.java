package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.EPostulante;
import com.entity.ETipo;
@Repository
public interface PostulanteRepository extends JpaRepository<EPostulante,Integer> {
	//@Query("select  *  from postulante where concat(nombre,' ',ApellidoPaterno,' ',ApellidoMaterno) like '%contenido%'")
	//@Query("select t from ETipo  t where t.parent_idtipo = :id")
	//List<EPostulante> buscarxParametroNombre(@Param("contenido")String contenido);
}
