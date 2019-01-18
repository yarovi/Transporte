package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.entity.EDispositivo;

import com.service.IGenericService;


@CrossOrigin
@RestController
@RequestMapping("/dispositivo")
public class DispositivoController {

	private static final Log LOG = LogFactory.getLog(DispositivoController.class);	
	
	@Autowired
	private IGenericService<EDispositivo> dispositivoService;
	
	@GetMapping("/all")
	public ResponseEntity<List<EDispositivo>> findDispositivo()
	{
		LOG.info("llamdno al findispositivo ... ");
		return new ResponseEntity<List<EDispositivo>>(dispositivoService.readAll(),HttpStatus.OK);
	}
	@GetMapping(path="/getid/{id}",produces=MediaType.APPLICATION_JSON_VALUE)//
	public ResponseEntity<EDispositivo> findDispositivoxId(@PathVariable(value = "id") int id)
	{
		
		EDispositivo dispositivo = new EDispositivo();
		dispositivo=dispositivoService.findItemxId(id);
		LOG.info("llamdno por id ... "+ dispositivo);
		
		return new ResponseEntity<EDispositivo>(dispositivo,HttpStatus.OK);
		//return new ResponseEntity<EDispositivo>(dispositivoService.findDispositivoxId(id),HttpStatus.OK);
				

	}
	@PutMapping("/update/{id}")
	public  ResponseEntity<EDispositivo>  updateDispsitivo(@PathVariable(value="id") int id,
			@Valid @RequestBody EDispositivo entity){
		LOG.info("Actualizando informacion un dispostivo Nuevo ... ");
		EDispositivo miDispositivo=dispositivoService.findItemxId(id); 	
			
		miDispositivo.setDescripcion(entity.getDescripcion());
		miDispositivo.setPuerto(entity.getPuerto());
		miDispositivo=dispositivoService.create(miDispositivo);
		return new ResponseEntity<EDispositivo>(miDispositivo,HttpStatus.OK);
		
	}
	
	@PostMapping("/create")
	public ResponseEntity<Void> createDispositivo(@RequestBody EDispositivo nuevoDispositivo){
		LOG.info("Creando un dispostivo Nuevo ... ");
		dispositivoService.create(nuevoDispositivo);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deleteDispositivo(@PathVariable(value="id") int id)
	{
		dispositivoService.delete(id);
		Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
	
	}
	//paginacion
	@GetMapping("/findget")
	public Page<EDispositivo> findPagiinated(@RequestParam("page") int page//,@RequestParam("size") int size
			){
		Page<EDispositivo> resultPage = dispositivoService.findPaginated(page, 4);
		if(page>resultPage.getTotalPages())
			return null;
		return resultPage;
	}
	@GetMapping("/findget2")
	public Page<EDispositivo> findPagiinated(){
		Page<EDispositivo> resultPage = dispositivoService.findPaginated(1, 2);
		if(1>resultPage.getTotalPages())
			return null;
		return resultPage;
	}

	
}
