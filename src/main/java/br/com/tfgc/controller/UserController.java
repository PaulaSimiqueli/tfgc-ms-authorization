package br.com.tfgc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.tfgc.domain.UserDomain;
import br.com.tfgc.interfaces.json.Usuario;
import br.com.tfgc.service.UserService;

@RestController
@RequestMapping("/authentication/v1")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(path="/users", method=RequestMethod.POST)
	public ResponseEntity<Object> createUser(@RequestBody Usuario user) {
		userService.createUser(user);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	@RequestMapping(path="/users", method=RequestMethod.GET)
	public ResponseEntity<List<Usuario>> recoveryUser() {
		
		
		return ResponseEntity.ok(userService.findAll());
	}
}
