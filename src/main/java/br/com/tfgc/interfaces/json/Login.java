package br.com.tfgc.interfaces.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Login {
	
	@JsonProperty(value = "username", required=true)
	private String username;
	@JsonProperty(value = "password", required=true)
	private String password;
	
	
	
	public String getPassword() {
		return password;
	}
	public String getUsername() {
		return username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
