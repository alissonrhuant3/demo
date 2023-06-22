package com.example.demo.model;

import java.util.Collection;

import jakarta.persistence.*;

@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nome")
	private String primeiroNome;
	@Column(name = "sobrenome")
	private String segundoNome;
	
	private String email;
	
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable (
			name = "users_roles",
			joinColumns = @JoinColumn(
					name = "user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(
					name = "role_id", referencedColumnName = "id"))
	
	private Collection<Role> roles;
	
	
	public User(long id, String primeiroNome, String segundoNome, String email, String password,
			Collection<Role> roles) {
		super();
		this.id = id;
		this.primeiroNome = primeiroNome;
		this.segundoNome = segundoNome;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPrimeiroNome() {
		return primeiroNome;
	}
	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}
	public String getSegundoNome() {
		return segundoNome;
	}
	public void setSegundoNome(String segundoNome) {
		this.segundoNome = segundoNome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

}
