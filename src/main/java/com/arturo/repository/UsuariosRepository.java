package com.arturo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arturo.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {
	
	Usuario findByUsernameAndPassword(String username, String password);

}
