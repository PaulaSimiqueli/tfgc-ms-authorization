package br.com.tfgc.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserDomain implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@Column(name = "name",  nullable = false)
	private String name;

	@Column(name = "username", nullable = false, unique = true)
	private String username;

	@Column(name = "type", nullable = false)
	private String typeUser;
	

	@Column(name = "password", nullable = false)
	private String password;
	
	
	public UserDomain() {
	}

	
	public UserDomain(Long id, String name, String username, String type, String password) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.typeUser = type;
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getType() {
		return typeUser;
	}

	public void setType(String type) {
		this.typeUser = type;
	}

}
