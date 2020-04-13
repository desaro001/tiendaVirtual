package com.arturo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.arturo.model.Articulo;
import com.arturo.repository.ArticulosRepository;

@Service
@Primary
public class ArticulosServiceJpa implements IArticulosService {

	@Autowired
	private ArticulosRepository articulosRepo;

	public List<Articulo> buscarTodos() {
		return articulosRepo.findAll();
	}

	public List<Articulo> buscarDestacados(String d) {
		return articulosRepo.findByDestacado(d);
	}

	public List<Articulo> buscarPrenda(String d) {
		return articulosRepo.findByNombreStartingWith(d);
	}

	public Articulo buscarPorId(Integer id) {
		Optional<Articulo> optional = articulosRepo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;

	}	
		
}
