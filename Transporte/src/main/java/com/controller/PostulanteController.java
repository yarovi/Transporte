package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.EPostulante;
import com.service.IGenericService;

@CrossOrigin
@RestController
@RequestMapping("/postulante")
public class PostulanteController {

	private static final Log LOG = LogFactory.getLog(PostulanteController.class);	

	@Autowired
	private IGenericService<EPostulante> postulanteService;
	//listando todos los elementos
	@GetMapping("/all")
	public ResponseEntity<List<EPostulante>>  findallpostulante(){
		LOG.info("llamdno al findallpostulante ... ");
		return new ResponseEntity<List<EPostulante>>(postulanteService.readAll(),HttpStatus.OK);
	}
	//obteniendo elemento por Id
	@GetMapping(path="/getid/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EPostulante> findPostulantexID(@PathVariable(value="id") int id){
		EPostulante postulante = new EPostulante();
		postulante=postulanteService.findItemxId(id);
		LOG.info("llamando por id ... "+ postulante);
		return new ResponseEntity<EPostulante>(postulante,HttpStatus.OK);
	}
	//actualizando elementos 
	@PutMapping("/update/{id}")
	public ResponseEntity<EPostulante> updatePostulante(@PathVariable(value ="id") int id,
			@Valid @RequestBody EPostulante entity){
			LOG.info("Actualizando informacion del postulante  ... ");
			EPostulante mipostulante =postulanteService.findItemxId(id);
			
			//cargando datos
			mipostulante.setCodDocuemnto(entity.getCodDocuemnto());
			mipostulante.setNroDocumento(entity.getNroDocumento());
			mipostulante.setCodSangre(entity.getCodSangre());
			mipostulante.setCodEstadoCivil(entity.getCodEstadoCivil());
			mipostulante.setCodigoPais(entity.getCodigoPais());
			mipostulante.setNombre(entity.getNombre());
			mipostulante.setApellidoPaterno(entity.getApellidoPaterno());
			mipostulante.setApellidoMaterno(entity.getApellidoMaterno());
			mipostulante.setFechaNacimiento(entity.getFechaNacimiento());
			mipostulante.setEstatura(entity.getEstatura());
			mipostulante.setCorreo(entity.getCorreo());
			mipostulante.setSexo(entity.getSexo());
			//fin
			mipostulante=postulanteService.create(mipostulante);
		return new ResponseEntity<EPostulante>(mipostulante,HttpStatus.OK);
	}
	//paginacion
	@GetMapping("/findget")
	public Page<EPostulante> findPagination(@RequestParam("page") int page){
		Page<EPostulante> resultadoPage = postulanteService.findPaginated(page, 10);
		if (page > resultadoPage.getTotalPages()) {
			return null;
		}
		return resultadoPage;
	}
}
