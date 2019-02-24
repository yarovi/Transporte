package com.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.EPostulante;
import com.modeloDTO.modeloPostulanteDTO;
@Repository
public interface PostulanteRepository extends JpaRepository<EPostulante,Integer> {
	//@Query("select  *  from postulante where concat(nombre,' ',ApellidoPaterno,' ',ApellidoMaterno) like '%contenido%'")
	//@Query("select t from ETipo  t where t.parent_idtipo = :id")
	//List<EPostulante> buscarxParametroNombre(@Param("contenido")String contenido);
	
	
	@Query("select  new com.modeloDTO.modeloPostulanteDTO(t.id,concat(t.apellidopaterno,' ',t.apellidomaterno,' ',t.nombre),t.fecha)"+
	" from EPostulante t  ")
	//order by t.id desc
	List<modeloPostulanteDTO> findPostulantetoExamen();//@Param("valor") String valor,Pageable pageable);
	//t.estado =:'R' and
	//concat(t.ApellidoPaterno,' ',t.ApellidoMaterno,' ',
	//@Query("select  new com.modeloDTO.modeloPostulanteDTO(t.id,concat(t.apellidopaterno, '',t.fechaRegistro) as nom,'hoa') from EPostulante t where  t.nombre like '%:valor%'")

	//cast(t.fechaRegistro as Date)
}
