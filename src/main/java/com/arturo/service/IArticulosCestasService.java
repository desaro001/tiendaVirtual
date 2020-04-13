package com.arturo.service;

import java.util.List;

import com.arturo.model.ArticuloCesta;

public interface IArticulosCestasService {
	
	void altaArticuloCesta(ArticuloCesta articuloCesta);
	List<ArticuloCesta> buscarArticulos(int idCesta);
	ArticuloCesta ConsultarIdArticuloCesta(int idArticulo, int idCesta);
	void eliminarAc(Integer idAc);

}
