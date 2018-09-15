package br.com.tfgc.service;


import java.util.List;

import br.com.tfgc.exceptions.AuthenticationFailedException;
import br.com.tfgc.exceptions.UsernameAlreadyExistsException;
import br.com.tfgc.interfaces.json.Login;
import br.com.tfgc.interfaces.json.Usuario;

public interface UserService {

	
	void createUser(Usuario user) throws UsernameAlreadyExistsException;
	List<Usuario> findAll();
	
	void loginUser (Login login) throws AuthenticationFailedException;

}
