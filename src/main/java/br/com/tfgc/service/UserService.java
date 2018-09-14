package br.com.tfgc.service;


import java.util.List;

import br.com.tfgc.interfaces.json.Usuario;

public interface UserService {

	
	void createUser(Usuario user);
	List<Usuario> findAll();

}
