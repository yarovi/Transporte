package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.EPostulante;
import com.service.IServicePostulante;
import com.serviceimpl.SercicePostulanteImpl;

@CrossOrigin
@RestController
@RequestMapping("/postulantes")
public class PostulanteController {

	private static final Log LOG = LogFactory.getLog(PostulanteController.class);	

	@Autowired
	private IServicePostulante postulanteService;
	//listando todos los elementos
	@GetMapping("/all")
	public ResponseEntity<List<EPostulante>>  findallpostulante(){
		List<EPostulante> lstPostulante=postulanteService.readAll();
		LOG.info("Todos los postulante  ... "+ lstPostulante);
		LOG.info("llamdno al findallpostulante ... ");
		return new ResponseEntity<List<EPostulante>>(lstPostulante,HttpStatus.OK);
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
			mipostulante.setId(entity.getId());
			mipostulante.setApellidopaterno(entity.getApellidopaterno());
			mipostulante.setApellidomaterno(entity.getApellidomaterno());
			mipostulante.setNombre(entity.getNombre());
			mipostulante.setCoddocumento(entity.getCoddocumento());
			mipostulante.setNrodocumento(entity.getNrodocumento());
			mipostulante.setFechanacimiento(entity.getFechanacimiento());
			mipostulante.setEdad(entity.getEdad());
			mipostulante.setSexo(entity.getSexo());
			mipostulante.setCodgrado(entity.getCodgrado());
			mipostulante.setCodestadocivil(entity.getCodestadocivil());
			mipostulante.setCodpais(entity.getCodpais());
			mipostulante.setDireccion(entity.getDireccion());
			mipostulante.setCorreo(entity.getCorreo());
			mipostulante.setObservacion(entity.getObservacion());
			//fin
			mipostulante=postulanteService.create(mipostulante);
		return new ResponseEntity<EPostulante>(mipostulante,HttpStatus.OK);
	}
	//creando un nuevo postulante
	@PostMapping("/postulante")
	public ResponseEntity<Void> createPostulante(
			@RequestBody EPostulante newpostulante){
		LOG.info("Los datos antes de isnertar son  : "+ newpostulante);
		postulanteService.create(newpostulante);
		return new ResponseEntity<Void>(HttpStatus.OK);
		
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
	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deleteDispositivo(@PathVariable(value="id") int id)
	{
		postulanteService.delete(id);
		Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;	
	}
//	@GetMapping("buscarxparametro")
//	public Page
}
