package com.arturo.service;

import java.util.List;

import com.arturo.model.Cesta;

public interface ICestasService {
	
	List<Cesta> buscarCesta(Integer idUsuario, String tipo);
	void guardarCesta(Cesta cesta);
	List<Cesta> buscarPedidos(Integer idUsuario, String tipo);
	Cesta buscarPorId(Integer id);

}
