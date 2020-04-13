package com.arturo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arturo.model.Usuario;
import com.arturo.repository.UsuariosRepository;

@Service
public class UsuariosService implements IUsuariosService {
	
	@Autowired
	private UsuariosRepository usuariosRepo;
	
	public void guardarUsuario(Usuario usuario) {
			
		usuariosRepo.save(usuario);
	}
	
	public Usuario buscarUsuario(String username, String password) {
		
		return usuariosRepo.findByUsernameAndPassword(username, password);
	}

}
