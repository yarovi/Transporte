package com.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.EEmpresa;
import com.exception.ModeloNotFoundException;
import com.service.IServiceEmpresa;

@CrossOrigin
@RestController
@RequestMapping("/empresa")
public class EmpresaController {

	private static final Log LOG = LogFactory.getLog(EmpresaController.class);	
	@Autowired
	private IServiceEmpresa empresaService;
	//findxID
	@GetMapping(path="/getinfoEmpresa",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<EEmpresa> getinfoEmpresa(@PathVariable(value="id") int id){
		EEmpresa empresa = new EEmpresa();
		empresa=empresaService.getinfoEmpresa();
		return new ResponseEntity<EEmpresa>(empresa,HttpStatus.OK);
	}
	//agregar
	@PostMapping("/create")
	public ResponseEntity<Void> createEmpresa(@RequestBody EEmpresa entity){
		LOG.info("Creando una empresita ... ");
		empresaService.create(entity);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	//modificar
	@PutMapping("/update/{id}")
	public ResponseEntity<EEmpresa> updateEmpresa(@PathVariable(value="id")int id,
			@Valid @RequestBody EEmpresa entity){
		LOG.info("Actualizando informacion empresa ... ");
		EEmpresa empresa = empresaService.findItemxId(id);
		if (empresa ==null) {
			throw new ModeloNotFoundException("No se encontro la empresa con id :"+ id);
		}
		empresa.setRuc(entity.getRuc());
		empresa.setRazonsocial(entity.getRazonsocial());
		empresa.setTelefono(entity.getTelefono());
		empresa.setDireccion(entity.getDireccion());
		empresa.setCorreo(entity.getCorreo());
		empresa.setPortal(entity.getPortal());
		empresa=empresaService.create(empresa);
		
		return new ResponseEntity<EEmpresa>(empresa,HttpStatus.OK);
	}
}
