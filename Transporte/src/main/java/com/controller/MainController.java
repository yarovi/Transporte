package com.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	private static final Log LOG = LogFactory.getLog(MainController.class);

	@GetMapping("/")
	public ResponseEntity<Void> redirecMain() {
		LOG.info(" cargando main page ...");

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@GetMapping("/e")
	public String saludoe() {
		LOG.info(" cargando main page ...");
		return "soy e";
	}
}
