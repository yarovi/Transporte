package com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.EPais;
import com.entity.ETipo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.service.IGenericService;



@CrossOrigin
@RestController
@RequestMapping("/tipo")
public class TipoController {
	private static final Log LOG = LogFactory.getLog(TipoController.class);

	@Autowired
	private IGenericService<ETipo> tipoService;
	@Autowired
	private IGenericService<EPais> paisService;
	@GetMapping("/allinfopostulante")
	public ResponseEntity<Map<String,List<ETipo>> > allinfopostulante(){ //List<Documento>
		List<ETipo> lstTipo=null;
		List<EPais> lstPais=null;
		Gson obj = new GsonBuilder().create();
		Map<String,List<ETipo>> miMap = new HashMap<String,List<ETipo>>(); 
		String rpta="";
		try {
			//cargando documentos
			lstTipo= tipoService.findItemCustom(4);
			miMap.put("identificacion", lstTipo);	
			//cargando estado civil
			lstTipo= tipoService.findItemCustom(3);
			miMap.put("estadocivil", lstTipo);
			//cargando grado academico
			lstTipo= tipoService.findItemCustom(1);
			miMap.put("grado", lstTipo);
			rpta= obj.toJson(miMap);
			//lista de paises
			lstPais=paisService.readAll();
			lstTipo=null;
			lstTipo= new ArrayList<ETipo>();
			for(EPais p :lstPais) {
				ETipo etipo = new ETipo();
				etipo.setTipoid(p.getId());
				etipo.setDescripcion(p.getNombre());
				lstTipo.add(etipo);
			}
			miMap.put("paises", lstTipo);			
			LOG.info("informacion.. " +rpta);
			;
		}catch (Exception e) {
			LOG.info("hay no se malogro... " +e.getMessage());
		}
		
		return new ResponseEntity<Map<String,List<ETipo>> >(miMap,HttpStatus.OK);
	}
}
