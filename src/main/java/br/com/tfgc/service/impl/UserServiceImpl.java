package br.com.tfgc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tfgc.domain.UserDomain;
import br.com.tfgc.interfaces.json.Usuario;
import br.com.tfgc.repository.UserRepository;
import br.com.tfgc.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public List<UserDomain> findByName(String name) {
		return userRepository.findByNameContainingIgnoreCase(name);
	}

	@Override
	public void createUser(Usuario user) {
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
}
