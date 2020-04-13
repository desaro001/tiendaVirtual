package com.arturo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.arturo.model.Articulo;

//public interface CategoriasRepository extends CrudRepository<Categoria, Integer> { 
public interface ArticulosRepository extends JpaRepository<Articulo, Integer> {
	
	List<Articulo> findByDestacado(String d);
	List<Articulo> findByNombreStartingWith(String d);

	
}
