package com.arturo.service;

import java.util.List;

import com.arturo.model.Articulo;


public interface IArticulosService {	
	List<Articulo> buscarTodos();
	List<Articulo> buscarDestacados(String d);
	List<Articulo> buscarPrenda(String d);
	Articulo buscarPorId(Integer id);
	
}