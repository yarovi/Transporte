package com.controladores;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.utilidades.PathView;

@Controller
public class MainController {

	private static final Log LOG = LogFactory.getLog(MainController.class);

	@GetMapping("/")
	public String redirecMain() {
		LOG.info(" cargando main page ...");
		return PathView.vistaMain;
	}
}
