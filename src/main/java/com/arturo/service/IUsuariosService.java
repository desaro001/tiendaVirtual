package com.arturo.service;

import com.arturo.model.Usuario;

public interface IUsuariosService {
	Usuario buscarUsuario(String username, String password);
	void guardarUsuario(Usuario usuario);

}
