package com.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.utility.PathView;

@RestController
public class MainController {

	private static final Log LOG = LogFactory.getLog(MainController.class);

	@GetMapping("/")
	public ResponseEntity<Void> redirecMain() {
		LOG.info(" cargando main page ...");
//		ModelAndView mView = new ModelAndView(PathView.vistaMain);
		//return PathView.vistaMain;
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@GetMapping("/e")
	public String saludoe() {
		LOG.info(" cargando main page ...");
//		ModelAndView mView = new ModelAndView(PathView.vistaMain);
		//return PathView.vistaMain;
		return "soy e";
	}
}
