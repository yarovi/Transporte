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

import com.entity.ETipo;
import com.exception.ModeloNotFoundException;
import com.modeloDTO.modelTipoDTO;
import com.service.IServiceTipo;
import com.utilidad.ParametroPaginacion;

@CrossOrigin
@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	private static final Log LOG = LogFactory.getLog(CategoriaController.class);
	@Autowired
	private IServiceTipo tipoCategoria;
	//buscamos por categria es paginable
	@GetMapping("/findPageByCategory")
	public Page<ETipo> findPageByCategory(@RequestParam("page") int page)
	{
		Page<ETipo> resultadoPage = tipoCategoria.findPaginated(page, ParametroPaginacion.tamPageSubcateoria);
		if (page > resultadoPage.getTotalPages()) {
			return null;
		}
		return resultadoPage;
	}
	//buscamos por una categoria especifica en base al ID
	@GetMapping(path="/getItemById/{id}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ETipo> getItemById(@PathVariable(value="id") int id){
		ETipo tipo = new ETipo();
		tipo=tipoCategoria.findItemxId(id);
		LOG.info("llamando por id ... "+ tipo);
		return new ResponseEntity<ETipo>(tipo,HttpStatus.OK);
	}
	//obtenemos todas las categorias en base a un modelo DTO
	@GetMapping("/allCategory")
	public  ResponseEntity<List<modelTipoDTO>> getAllCategory(){
		List<modelTipoDTO> lstCategory = tipoCategoria.findByCategory();
		return new ResponseEntity<List<modelTipoDTO>>(lstCategory,HttpStatus.OK);
	}
	//creacion de un nuevo item de tipo categoria
	@PostMapping("/create")
	public ResponseEntity<Void> createCategory(@RequestBody ETipo entity){
		LOG.info("Creando una Categoria ... ");
		tipoCategoria.create(entity);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	//modificacion de un item tipo categoria
	@PutMapping("/update/{id}")
	public ResponseEntity<ETipo> updateCategory(@PathVariable(value="id") int id,
			@Valid @RequestBody ETipo entity)
	{
		LOG.info("Actualizando informacion categoria ... ");		
		ETipo mitipo= tipoCategoria.findItemxId(id);
		if (mitipo ==null)
			throw new ModeloNotFoundException("No se encontro el id : "+ id); 
		mitipo.setDescripcion(entity.getDescripcion());
		mitipo.setReferencia(entity.getReferencia());
		mitipo=tipoCategoria.create(mitipo);
		return new ResponseEntity<ETipo>(mitipo,HttpStatus.OK);		
	}
	//eliminacion de un item tipo categoria
	@DeleteMapping("/delete/{id}")
	public Map<String,Boolean> deleteCategory(@PathVariable(value="id")int id){
		tipoCategoria.delete(id);
		Map<String,Boolean> response= new HashMap<>();
		response.put("delete", Boolean.TRUE);
		 
		return response;
//		throw new ModeloNotFoundException("No se encontro el id : "+ id);
	}
}
