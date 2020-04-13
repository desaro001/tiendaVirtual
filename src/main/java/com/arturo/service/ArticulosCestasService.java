package com.arturo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arturo.model.ArticuloCesta;
import com.arturo.repository.ArticulosCestasRepository;

@Service
public class ArticulosCestasService implements IArticulosCestasService {

	@Autowired
	private ArticulosCestasRepository articuloCestaRepo;

	public void altaArticuloCesta(ArticuloCesta articuloCesta) {
		articuloCestaRepo.save(articuloCesta);
	}

	public List<ArticuloCesta> buscarArticulos(int idCesta) {
		return articuloCestaRepo.findByIdCesta(idCesta);
	}	
	
	public ArticuloCesta ConsultarIdArticuloCesta(int idArticulo, int idCesta) {
		return articuloCestaRepo.findByIdArticuloAndIdCesta(idArticulo, idCesta);
	}
	
	public void eliminarAc(Integer idAc) {
		articuloCestaRepo.deleteById(idAc);		
	}

}
