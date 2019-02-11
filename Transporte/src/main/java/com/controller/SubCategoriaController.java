package com.controller;

import java.util.HashMap;
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

import com.entity.ETipo;
import com.exception.ModeloNotFoundException;
import com.service.IServiceTipo;
import com.utilidad.ParametroPaginacion;

@CrossOrigin
@RestController
@RequestMapping("/subcategoria")
public class SubCategoriaController {

	private static final Log LOG = LogFactory.getLog(SubCategoriaController.class);
	@Autowired
	private IServiceTipo tipoSubCategoria;
	@GetMapping("/findPageBySubCategory")
	public Page<ETipo> findPageBySubCategory(@RequestParam("id") int id,@RequestParam("page") int page)
	{
		Page<ETipo> resultadoPage = tipoSubCategoria.findPageBySubCategoryEntity(id,page, ParametroPaginacion.tamPageSubcateoria);
		if (page > resultadoPage.getTotalPages()) {
			return null;
		}
		return resultadoPage;
	}
	//buscamos por una subcategoria especifica 
	@GetMapping(path="/getItemById/{id}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ETipo> getItemById(@PathVariable(value="id") int id){
		ETipo subtipo = new ETipo();
		subtipo=tipoSubCategoria.findItemxId(id);
		LOG.info("llamando por id ... "+ subtipo);
		return new ResponseEntity<ETipo>(subtipo,HttpStatus.OK);
	}
	//creando una nueva categoria
	@PostMapping("/create")
	public ResponseEntity<Void> createSubCategory(@Valid @RequestBody ETipo entity){
		LOG.info("Creando una Sub Categoria ... ");
		tipoSubCategoria.create(entity);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<ETipo> updateSubCategory(@PathVariable(value="id") int id,
			@Valid @RequestBody ETipo entity){
		LOG.info("Actualizando informacion Sub-categoria ... ");	
		ETipo mitipo = tipoSubCategoria.findItemxId(id);
		if (mitipo ==null)
			throw new ModeloNotFoundException("No se encontro el id : "+ id); 
		mitipo.setDescripcion(entity.getDescripcion());
		mitipo.setReferencia(entity.getReferencia());
		mitipo.setParent_idtipo(entity.getParent_idtipo());
		mitipo=tipoSubCategoria.create(mitipo);
		return new ResponseEntity<ETipo>(mitipo,HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public Map<String,Boolean> deelteSubCategory(@PathVariable(value="id")int id){
		tipoSubCategoria.delete(id);
		Map<String,Boolean> response = new HashMap<>();
		response.put("delete",Boolean.TRUE);
		return response;
		
	}
}
