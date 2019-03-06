package com.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.EPostulante;
import com.modeloDTO.modeloEvaluacionDTO;
import com.modeloDTO.modeloPostulanteDTO;
@Repository
public interface PostulanteRepository extends JpaRepository<EPostulante,Integer> {
	//@Query("select  *  from postulante where concat(nombre,' ',ApellidoPaterno,' ',ApellidoMaterno) like '%contenido%'")
	//@Query("select t from ETipo  t where t.parent_idtipo = :id")
	//List<EPostulante> buscarxParametroNombre(@Param("contenido")String contenido);	
	@Query("select  new com.modeloDTO.modeloPostulanteDTO(t.id,concat(t.apellidopaterno,' ',t.apellidomaterno,' ',t.nombre),t.fecharegistro) from EPostulante t  order by t.id desc")
	List<modeloPostulanteDTO> findPostulantetoExamen();	
	//paginacion principal EVALUIACION (maquinas)
	@Query("select new com.modeloDTO.modeloEvaluacionDTO(p.id,p.nrodocumento,concat(p.apellidopaterno,' ',p.apellidomaterno,' ',p.nombre),p.edad,p.sexo) from EPostulante  p where concat(p.apellidopaterno,' ',p.apellidomaterno,' ',p.nombre) like %:valor% order by p.id desc")
	Page<modeloEvaluacionDTO> findPostulantetoEvaluacion(@Param("valor") String valor,Pageable pageable);	
	@Query("select new com.modeloDTO.modeloEvaluacionDTO(p.id,p.nrodocumento,concat(p.apellidopaterno,' ',p.apellidomaterno,' ',p.nombre),p.edad,p.sexo) from EPostulante  p where p.nrodocumento like %:valor% order by p.id desc")
	Page<modeloEvaluacionDTO> findPostulantetoEvaluacionxNroDocumento(@Param("valor") String valor,Pageable pageable);	
	//paginacion  principal POSTULANTE
	@Query("select p from EPostulante p where concat(p.apellidopaterno,' ',p.apellidomaterno,' ',p.nombre) like %:valor% order by p.id desc")
	Page<EPostulante> findPaginatedCustomxNombre(@Param("valor") String valor,Pageable pageable);
	@Query("select p from EPostulante  p where p.nrodocumento like %:valor% order by p.id desc")
	Page<EPostulante> findPaginatedCustomxDOC(@Param("valor") String valor,Pageable pageable);
	//paginacion  principal de EXAMEN
	
	
	//nota
	// se puede usar
	//TIMESTAMPDIFF(YEAR,p.fechanacimiento,CURDATE())
}
