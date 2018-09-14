package br.com.tfgc.interfaces.json;

public class Usuario {

	private Long userId;
	private String fullNameUser;
	private String username;
	private String typeUser;
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFullNameUser() {
		return fullNameUser;
	}

	public void setFullNameUser(String fullNameUser) {
		this.fullNameUser = fullNameUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTypeUser() {
		return typeUser;
	}

	public void setTypeUser(String typeUser) {
		this.typeUser = typeUser;
	}

	public Usuario(Long userId, String fullNameUser, String username, String typeUser) {
		super();
		this.userId = userId;
		this.fullNameUser = fullNameUser;
		this.username = username;
		this.typeUser = typeUser;
	}

	public Usuario() {

	}

}
