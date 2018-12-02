package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	@PutMapping("/dispositivo/update")
	public ResponseEntity<EDispositivo> updateDispsitivo(@PathVariable(value="id") int id,
			@Valid @RequestBody EDispositivo entity){
		
		EDispositivo miDispositivo=dispositivoService.findDispositivoxId(id);
		miDispositivo.setDescripcion(entity.getDescripcion());
		miDispositivo.setPuerto(entity.getPuerto());
		miDispositivo=dispositivoService.createDispositivo(miDispositivo);
		return new ResponseEntity<EDispositivo>(miDispositivo,HttpStatus.OK);
		
	}
	
	@PostMapping("dispositivos")
	public ResponseEntity<Void> createDispositivo(@RequestBody EDispositivo nuevoDispositivo){
		
		dispositivoService.createDispositivo(nuevoDispositivo);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	
}
