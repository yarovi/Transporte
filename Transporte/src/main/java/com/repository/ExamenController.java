package com.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.IServiceExamen;

@CrossOrigin
@RestController
@RequestMapping("/examen")
public class ExamenController {
	
	@Autowired
	private IServiceExamen examenService;
	

}
