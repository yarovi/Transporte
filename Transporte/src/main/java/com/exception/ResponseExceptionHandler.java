package com.exception;

import java.sql.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.controller.CategoriaController;

@CrossOrigin
@ControllerAdvice
@RestController
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler{

	private static final Log LOG = LogFactory.getLog(ResponseExceptionHandler.class);
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> manejarTodasExcepciones(Exception ex,WebRequest request){
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(0),ex.getMessage(),request.getDescription(true));
		if(exceptionResponse.getMensaje().contains("could not execute statement; SQL [n/a]; constraint [null];"))
		{	exceptionResponse.setMensaje("No se puede Eliminar");
			exceptionResponse.setDetalle("Hay uno o varios registros asociados a este dato.");
		}
		else if(exceptionResponse.getMensaje().contains("No class")) {
			exceptionResponse.setMensaje("No se puede Eliminar");
			exceptionResponse.setDetalle("No existe ese registro en la base de datos.");
		}
		LOG.info("llamando al error en Internal Server ... "+ exceptionResponse);
		return new ResponseEntity(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(ModeloNotFoundException.class)
	public final ResponseEntity<Object> manejarTodasExcepciones(ModeloNotFoundException ex,WebRequest request){
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(0), ex.getMessage(), request.getDescription(false));
		LOG.info("llamando al error en Not Found ... "+ exceptionResponse);
		return new ResponseEntity(exceptionResponse,HttpStatus.NOT_FOUND);
	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,HttpHeaders header, HttpStatus status, WebRequest request){
		String errores="";
		//errores = ex.getBindingResult().getAllErrors().forEach(r -> r.getDefaultMessage());
		for (ObjectError e : ex.getBindingResult().getAllErrors()) {
			errores += e.getDefaultMessage();
		}
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(0), "Validación fallida", errores);
		LOG.info("llamando al error en Bad Request... "+ exceptionResponse);
		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
}
