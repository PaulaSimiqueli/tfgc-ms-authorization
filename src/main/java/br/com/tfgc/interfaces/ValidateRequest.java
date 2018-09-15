package br.com.tfgc.interfaces;

import br.com.tfgc.exceptions.MissingRequiredPropertiesException;
import br.com.tfgc.interfaces.json.Login;
import br.com.tfgc.interfaces.json.Usuario;

public class ValidateRequest {
	
	
	public static void loginValidate(Login login) throws MissingRequiredPropertiesException {
		
		if(login.getUsername()==null) {
			throw new MissingRequiredPropertiesException("username is required");
		}
		
		if(login.getPassword()==null) {
			throw new MissingRequiredPropertiesException("password is required");
		}
		
		
	}
	
	public static void createUserValidate(Usuario user) throws MissingRequiredPropertiesException {
		
		if(user.getUsername()==null) {
			throw new MissingRequiredPropertiesException("username is required");
		}
		
		if(user.getPassword()==null) {
			throw new MissingRequiredPropertiesException("password is required");
		}
		
		if(user.getUserId()==null) {
			throw new MissingRequiredPropertiesException("userId is required");
		}
		
		if(user.getFullNameUser()==null) {
			throw new MissingRequiredPropertiesException("fullNameUser is required");
		}
		
		
	}
	
}
