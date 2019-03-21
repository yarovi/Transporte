package com.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.EExamen;
import com.modeloDTO.modeloExamenDTO;
@Repository
public interface ExamenRepository extends JpaRepository<EExamen, Integer> {
/*
select e.id,t1.descripcion,t2.descripcion,
t3.descripcion,t4.descripcion,t5.descripcion,UPPER(concat(p.ApellidoPaterno,' ',p.ApellidoMaterno,' ',p.Nombre))
from examen e
inner join tipo t1 on t1.tipoid=e.codlicencia
inner join tipo t2 on t2.TipoId=e.codcategoria
inner join tipo t3 on t3.TipoId=e.codactitud
inner join tipo t4 on t4.TipoId=e.codcomportamiento
inner join tipo t5 on t5.TipoId=e.codsangre
inner join postulante p on p.id=e.postulante_id;
 */
	
	// version 1
	@Query("select new com.modeloDTO.modeloExamenDTO("
			+ "e.id,"
			+ "t1.descripcion,"
			+ "t2.descripcion,"
			+ "t3.descripcion,"
			+ "t4.descripcion,"
			+ "t5.descripcion,"
			+ "UPPER(concat(p.apellidopaterno,' ',p.apellidomaterno,' ',p.nombre))"
			+ ") from EExamen e ,ETipo t1,ETipo t2,ETipo t3,ETipo t4,ETipo t5,EPostulante p"
			+ " where "
			+ "t1.tipoid = e.codlicencia and "
			+ "t2.tipoid = e.codcategoria and "
			+ "t3.tipoid = e.codactitud and "
			+ "t4.tipoid = e.codcomportamiento and "
			+ "t5.tipoid = e.codsangre and "
			+ "p.id = e.postulante.id and "			
			+ "UPPER(concat(p.apellidopaterno,' ',p.apellidomaterno,' ',p.nombre)) like %:valor%")
	Page<modeloExamenDTO> findPostulantetoExamenxNombre(@Param("valor") String valor,Pageable pageable);
	
}
