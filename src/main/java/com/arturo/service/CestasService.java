package com.arturo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arturo.model.Cesta;
import com.arturo.repository.CestasRepository;

@Service
public class CestasService implements ICestasService {
	
	@Autowired
	private CestasRepository cestasRepo;	

	public List<Cesta> buscarCesta(Integer idUsuario, String tipo) {
		return cestasRepo.findByIdUsuarioAndTipo(idUsuario, tipo);
		
	}
	
	public List<Cesta> buscarPedidos(Integer idUsuario, String tipo) {
		return cestasRepo.findByIdUsuarioAndTipo(idUsuario, tipo);
	}
	
	public void guardarCesta(Cesta cesta) {
		
		cestasRepo.save(cesta);
	}
	
	public Cesta buscarPorId(Integer id) {
		Optional<Cesta> optional = cestasRepo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;

	}	

}
