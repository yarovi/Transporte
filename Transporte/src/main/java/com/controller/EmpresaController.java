package com.controller;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.multipart.MultipartFile;

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
	@GetMapping(path="/getinfoEmpresa",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EEmpresa> getinfoEmpresa(){
		List<EEmpresa> lstEmpresa = empresaService.readAll();
		EEmpresa empresa = new EEmpresa();
		if (lstEmpresa.size()==1) {
			empresa=lstEmpresa.get(0);
		}		
		//empresa=empresaService.getinfoEmpresa();
		return new ResponseEntity<EEmpresa>(empresa,HttpStatus.OK);
	}
	@GetMapping("/getid/{id}")
	public ResponseEntity<EEmpresa> findEmpresaxId(@PathVariable(value="id") int id){
		EEmpresa empresa = new EEmpresa();
		empresa=empresaService.findItemxId(id);
		return new ResponseEntity<EEmpresa>(empresa,HttpStatus.OK);
	}
	//agregar nueva empresa
	@PostMapping("/create")
	public ResponseEntity<EEmpresa> createEmpresa(@RequestBody EEmpresa entity){
		LOG.info("Creando una empresita ... "+entity);
		empresaService.create(entity);
		return new ResponseEntity<EEmpresa>(entity,HttpStatus.OK);
	}
	//update la informacio de la empresa
	@PutMapping("/update/{id}")
	public ResponseEntity<EEmpresa> updateEmpresa(@PathVariable(value="id") int id,
		@Valid @RequestBody EEmpresa entity){
			EEmpresa empresa=empresaService.findItemxId(id);
			if (empresa ==null) {
				throw new ModeloNotFoundException("No se encontro la empresa con id :"+ id);
			}
			empresa.setRuc(entity.getRuc());
			empresa.setRazonsocial(entity.getRazonsocial());
			empresa.setTelefono(entity.getTelefono());
			empresa.setDireccion(entity.getDireccion());
			empresa.setPortal(entity.getPortal());
			empresa.setRepresentante(entity.getRepresentante());
			LOG.info("Actualizando informacion empresa ... "+ empresa);
			empresa=empresaService.create(empresa);
			return new ResponseEntity<EEmpresa>(empresa,HttpStatus.OK);
		}
	//actualñizar el logo de la empresa
	@PutMapping("/logo/{id}")
	public ResponseEntity<Void> actualizarLogo(@PathVariable(value="id") int id,
			@RequestParam("file") byte [] file)
	{
		
		if (id==0)
		{
			 throw new ModeloNotFoundException("Nos se encontro ninguna registro para el codigo"+ id+ "para asignar el logo");  
		}
		byte [] decodeByte=null;
		try {
			//decodeByte=Base64.getDecoder().decode(file.getBytes());
		}catch(Exception ex)
		{
			 throw new ModeloNotFoundException("Error :"+ ex.getMessage());  
		}	

		LOG.info("informacion del logo es .. " +decodeByte);
		int rpta =0;
		if (file!=null) {
			rpta=empresaService.updateLogo(id, file);
		}else{
			 throw new ModeloNotFoundException("No se relizo ninguna actulizacion en la imagen.");  
		}		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@PutMapping("/logo2/{id}")
	public ResponseEntity<Void> actualizarLogo(@PathVariable(value="id") int id,
			@RequestParam("file") MultipartFile file)
	{
		int rpta =0;
		if (id==0)
		{
			 throw new ModeloNotFoundException("Nos se encontro ninguna registro para el codigo"+ id+ "para asignar el logo");  
		}
		byte [] decodeByte=null;
		try {
			rpta=empresaService.updateLogo(id, file.getBytes());
			//decodeByte=Base64.getDecoder().decode(file.getBytes());
			
		}catch(Exception ex)
		{
			LOG.info("informacion del logo es .. " +ex.getMessage());
			 throw new ModeloNotFoundException("Error :"+ ex.getMessage());  
		}	

		LOG.info("informacion del logo es .. " +decodeByte);
		
//		if (decodeByte!=null) {
//			rpta=empresaService.updateLogo(id, decodeByte);
//		}else{
//			 throw new ModeloNotFoundException("No se relizo ninguna actulizacion en la imagen.");  
		//}		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	//eliminar datos de la empresa
	@DeleteMapping("/delete/{id}")
	public Map<String,Boolean> deleteEmpresa(@PathVariable(value="id") int id){
		
		empresaService.delete(id);
		Map<String,Boolean> response = new HashMap<>();
		response.put("delete", Boolean.TRUE);
		return response;
	}
	
	
	//modificar
//	@PutMapping("/update/{id}")
//	public ResponseEntity<EEmpresa> updateEmpresa(@PathVariable(value="id")int id,
//			@Valid @RequestBody EEmpresa entity){
//		LOG.info("Actualizando informacion empresa ... ");
//		EEmpresa empresa = empresaService.findItemxId(id);
//		if (empresa ==null) {
//			throw new ModeloNotFoundException("No se encontro la empresa con id :"+ id);
//		}
//		empresa.setRuc(entity.getRuc());
//		empresa.setRazonsocial(entity.getRazonsocial());
//		empresa.setTelefono(entity.getTelefono());
//		empresa.setDireccion(entity.getDireccion());
//		empresa.setCorreo(entity.getCorreo());
//		empresa.setPortal(entity.getPortal());
//		empresa=empresaService.create(empresa);
//		
//		return new ResponseEntity<EEmpresa>(empresa,HttpStatus.OK);
//	}
}
