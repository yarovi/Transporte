package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

@RestController
@RequestMapping("/api")
public class DispositivoController {

	private static final Log LOG = LogFactory.getLog(DispositivoController.class);	
	
	@Autowired
	private IGenericService<EDispositivo> dispositivoService;
	
	@GetMapping("/dispositivos")
	public ResponseEntity<List<EDispositivo>> findDispositivo()
	{
		LOG.info("llamdno al findispositivo ... ");
		return new ResponseEntity<List<EDispositivo>>(dispositivoService.getAllDispositivo(),HttpStatus.OK);
	}
	@GetMapping("/dispositivos/{id}")
	public HttpEntity<EDispositivo> findDispositivoxId(@PathVariable int id)
	{
		EDispositivo dispositivo = new EDispositivo();
		dispositivo=dispositivoService.findDispositivoxId(id);
		return new ResponseEntity<EDispositivo>(dispositivo,HttpStatus.OK);
	}
	@PutMapping("/dispositivos/{id}")
	public  ResponseEntity<EDispositivo>  updateDispsitivo(@PathVariable(value="id") int id,
			@Valid @RequestBody EDispositivo entity){
		LOG.info("Actualizando informacion un dispostivo Nuevo ... ");
		EDispositivo miDispositivo=dispositivoService.findDispositivoxId(id); 	
			
		miDispositivo.setDescripcion(entity.getDescripcion());
		miDispositivo.setPuerto(entity.getPuerto());
		miDispositivo=dispositivoService.createDispositivo(miDispositivo);
		return new ResponseEntity<EDispositivo>(miDispositivo,HttpStatus.OK);
		
	}
	
	@PostMapping("/dispositivos")
	public ResponseEntity<Void> createDispositivo(@RequestBody EDispositivo nuevoDispositivo){
		LOG.info("Creando un dispostivo Nuevo ... ");
		dispositivoService.createDispositivo(nuevoDispositivo);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@DeleteMapping("/dispositivos/{id}")
	public Map<String, Boolean> deleteDispositivo(@PathVariable(value="id") int id)
	{
		dispositivoService.deleteDispositivo(id);
		Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
	
	}

	
}
