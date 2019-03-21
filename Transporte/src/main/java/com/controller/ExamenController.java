package com.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
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

import com.entity.EExamen;
import com.entity.EPostulante;
import com.modeloDTO.modeloExamenDTO;
import com.paginablerepository.PaginableExamenRepository;
import com.service.IServiceExamen;
import com.service.IServicePostulante;
import com.utilidad.ParametroPaginacion;

@CrossOrigin
@RestController
@RequestMapping("/examen")
public class ExamenController {
	
	private static final Log LOG = LogFactory.getLog(ExamenController.class);	
	
	@Autowired
	private IServiceExamen examenService;
	@Autowired
	private IServicePostulante postulanteService;
	@Autowired
	private PaginableExamenRepository serviceExamenCustom;
	
	@PostMapping("create")
	public ResponseEntity<Void> createExamen(
			@RequestBody EExamen nuevoExamen) {
		EPostulante postulante = new EPostulante();
		postulante = postulanteService.findItemxId(nuevoExamen.getCodpostulante());
		nuevoExamen.setPostulante(postulante);
		examenService.create(nuevoExamen);
		LOG.info("Creando un examen Nuevo ... ");
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<EExamen> updateExamen(
			@PathVariable(value="id") int id,
			@Valid @RequestBody EExamen entity)
	{
		LOG.info("Actualizando informacion un examen Nuevo ... ");
		EExamen miExamen = examenService.findItemxId(id);
		miExamen.setCodpostulante(entity.getCodpostulante());
		miExamen.setCodlicencia(entity.getCodlicencia());
		miExamen.setCodcategoria(entity.getCodcategoria());
		miExamen.setCodactitud(entity.getCodactitud());
		miExamen.setCodcomportamiento(entity.getCodcomportamiento());
		miExamen.setCodsangre(entity.getCodsangre());
		miExamen.setObservacion(entity.getObservacion());
		miExamen.setDefecto(entity.getDefecto());		
		return new ResponseEntity<EExamen>(miExamen,HttpStatus.OK);
	}
	//obteniendo por id
	@GetMapping("get/{id}")
	public ResponseEntity<EExamen> findExamenXID(
			@PathVariable(value="id") int id){
		EExamen examen=null;
		examen = examenService.findItemxId(id);
		LOG.info("llamando por id ... "+ examen);
		return new ResponseEntity<EExamen>(examen,HttpStatus.OK);
		
	}
	//eliminar un examen 
	@DeleteMapping("/delete/{id}")
	public Map<String,Boolean> deleteExamen(
			@PathVariable(value="id")int id){
		examenService.delete(id);
		Map<String,Boolean> response = new HashMap<>();
		response.put("delete", Boolean.TRUE);
		return response;
	}
	
	
	
	
	
	@GetMapping("/findget")
	public Page<modeloExamenDTO> findPaginationtoExamen(
			@RequestParam("tipo") String tipo,
			@RequestParam("valor") String valor,
			@RequestParam("page") int page
			){
		Page<modeloExamenDTO> resultadoPage =null;
//		if(tipo.equals("nrodocumento")) {
//			 resultadoPage = postulanteService.findPaginatedCustomxDOC(valor,page , ParametroPaginacion.tamPagePrincipal);
//		}else
//		{
//			 resultadoPage = serviceExamenCustom.getallExamen();
					 resultadoPage = examenService.findPostulantetoExamenxNombre(valor, page , ParametroPaginacion.tamPagePrincipal);
//		}
		
		//Page<EPostulante> resultadoPage = postulanteService.findPaginated(page, 10);
		if (page > resultadoPage.getTotalPages()) {
			return null;
		}
		return resultadoPage;
	}
	
	

}
