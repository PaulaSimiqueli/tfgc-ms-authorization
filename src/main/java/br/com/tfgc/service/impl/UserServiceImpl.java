package br.com.tfgc.service.impl;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import br.com.tfgc.domain.UserDomain;
import br.com.tfgc.interfaces.json.Login;
import br.com.tfgc.interfaces.json.Usuario;
import br.com.tfgc.repository.UserRepository;
import br.com.tfgc.service.UserService;

import br.com.tfgc.exceptions.AuthenticationFailedException;
import br.com.tfgc.exceptions.UsernameAlreadyExistsException;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public List<UserDomain> findByName(String name) {
		return userRepository.findByNameContainingIgnoreCase(name);
	}

	@Override
	public void createUser(Usuario user) throws UsernameAlreadyExistsException {
		UserDomain userDomain =  userRepository.findByUsernameIgnoreCase(user.getUsername());
		if(user !=null) {
			throw new UsernameAlreadyExistsException("Username Already Exists");
		}
		
		
		UserDomain newUser = new UserDomain(user.getUserId(), user.getFullNameUser(), user.getUsername(),
				user.getTypeUser(), user.getPassword());
		userRepository.save(newUser);

	}

	@Override
	public List<Usuario> findAll() {
		List<Usuario> users = new ArrayList<>();
		userRepository.findAll().forEach(userDomain -> users.add(
				new Usuario(userDomain.getId(), userDomain.getName(), userDomain.getUsername(), userDomain.getType())));

		return users;
	}

	@Override
	public void loginUser(Login login) throws AuthenticationFailedException {
		UserDomain user =  userRepository.findByUsernameIgnoreCase(login.getUsername());
		if(user ==null) {
			throw new AuthenticationFailedException("Username "+ login.getUsername()+" NOT Found");
		}
		String passDecript = new String(Base64Utils.decodeFromString(user.getPassword()));
		
		if(!passDecript.equals(login.getPassword())) {
			throw new AuthenticationFailedException("Invalid Password");
		}
		
		
	}
}
