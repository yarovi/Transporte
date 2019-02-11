package com.service;

import java.util.List;

import com.entity.EPostulante;

public interface IServicePostulante extends IGenericService<EPostulante> {

	List<EPostulante>buscarxParametro(String tipo,String valor);
}
