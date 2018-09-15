package br.com.tfgc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import br.com.tfgc.exceptions.AuthenticationFailedException;
import br.com.tfgc.exceptions.MissingRequiredPropertiesException;
import br.com.tfgc.exceptions.UsernameAlreadyExistsException;
import br.com.tfgc.interfaces.ValidateRequest;
import br.com.tfgc.interfaces.json.Login;
import br.com.tfgc.interfaces.json.Usuario;
import br.com.tfgc.service.UserService;

@RestController
@RequestMapping("/authentication/v1")
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private UserService userService;

	@RequestMapping(path="/users", method=RequestMethod.POST)
	public ResponseEntity<Object> createUser(@RequestBody Usuario user) {
		try {
			ValidateRequest.createUserValidate(user);
			userService.createUser(user);
		} catch (MissingRequiredPropertiesException e) {
			logger.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (UsernameAlreadyExistsException e) {
			logger.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(e.getMessage());
			
		}
		
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	@RequestMapping(path="/login", method=RequestMethod.POST)
	public ResponseEntity<Object> loginUser(@RequestBody Login login) {
		try {
			ValidateRequest.loginValidate(login);
			userService.loginUser(login);
		} catch (AuthenticationFailedException e) {
			
			logger.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		} catch (MissingRequiredPropertiesException e) {
			logger.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	@RequestMapping(path="/users", method=RequestMethod.GET)
	public ResponseEntity<List<Usuario>> recoveryUser() {
		
		
		return ResponseEntity.ok(userService.findAll());
	}
}
