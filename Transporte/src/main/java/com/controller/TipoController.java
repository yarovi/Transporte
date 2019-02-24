package com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.EPais;
import com.entity.ETipo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.modeloDTO.modelTipoDTO;
import com.service.IGenericService;
import com.service.IServiceTipo;
import com.utilidad.ParametroPaginacion;



@CrossOrigin
@RestController
@RequestMapping("/tipo")
public class TipoController {
	private static final Log LOG = LogFactory.getLog(TipoController.class);

	@Autowired
	private IServiceTipo tipoService;
	@Autowired
	private IGenericService<EPais> paisService;
	@GetMapping("/allinfopostulante")
	public ResponseEntity<Map<String,List<modelTipoDTO>> > allinfopostulante(){ //List<Documento>
		List<modelTipoDTO> lstTipo=null;
		List<EPais> lstPais=null;
		Gson obj = new GsonBuilder().create();
		Map<String,List<modelTipoDTO>> miMap = new HashMap<String,List<modelTipoDTO>>(); 
		String rpta="";
		try {
			//cargando documentos

			lstTipo= tipoService.findBySubCategory(4);
			miMap.put("identificacion", lstTipo);	
			//cargando estado civil
			lstTipo= tipoService.findBySubCategory(3);
			miMap.put("estadocivil", lstTipo);
			//cargando grado academico
			lstTipo= tipoService.findBySubCategory(1);
			miMap.put("grado", lstTipo);
			rpta= obj.toJson(miMap);
			//lista de paises
			lstPais=paisService.readAll();
			lstTipo=null;
			lstTipo= new ArrayList<modelTipoDTO>();
			for(EPais p :lstPais) {
				modelTipoDTO etipo = new modelTipoDTO();
				etipo.setId(p.getId());
				etipo.setDescripcion(p.getNombre());
				lstTipo.add(etipo);
			}
			miMap.put("paises", lstTipo);			
			LOG.info("informacion.. " +rpta);
			;
		}catch (Exception e) {
			LOG.info("hay no se malogro... " +e.getMessage());
		}
		
		return new ResponseEntity<Map<String,List<modelTipoDTO>> >(miMap,HttpStatus.OK);
	}
	@GetMapping("/allinfoexamen")
	public ResponseEntity<Map<String,List<modelTipoDTO>> > allinfoexamen(){ //List<Documento>
		List<modelTipoDTO> lstTipo=null;
		List<EPais> lstPais=null;
		Gson obj = new GsonBuilder().create();
		Map<String,List<modelTipoDTO>> miMap = new HashMap<String,List<modelTipoDTO>>(); 
		String rpta="";
		try {

			//licencia
			lstTipo= tipoService.findBySubCategory(67);
			miMap.put("licencia", lstTipo);	
			//actitud
			lstTipo= tipoService.findBySubCategory(72);
			miMap.put("actitud", lstTipo);
			//restriccion
			lstTipo= tipoService.findBySubCategory(95);
			miMap.put("restriccion", lstTipo);
			//categoria
			lstTipo= tipoService.findBySubCategory(103);
			miMap.put("categoria", lstTipo);
			//comportamiento
			lstTipo= tipoService.findBySubCategory(112);
			miMap.put("comportamiento", lstTipo);
			//enfermedad
			lstTipo= tipoService.findBySubCategory(82);
			miMap.put("enfermedad", lstTipo);
			//sangre
			lstTipo= tipoService.findBySubCategory(2);
			miMap.put("sangre", lstTipo);
			rpta= obj.toJson(miMap);
			LOG.info("informacion.. " +rpta);
			;
		}catch (Exception e) {
			LOG.info("hay no se malogro... " +e.getMessage());
		}
		
		return new ResponseEntity<Map<String,List<modelTipoDTO>> >(miMap,HttpStatus.OK);
	}
	
	@GetMapping("/allSubCategory/{id}")
	public  ResponseEntity<List<modelTipoDTO>> getAllSubCategory(@PathVariable(value="id") int id){
		List<modelTipoDTO> lstCategory = tipoService.findBySubCategory(id);
		return new ResponseEntity<List<modelTipoDTO>>(lstCategory,HttpStatus.OK);
	}
}
