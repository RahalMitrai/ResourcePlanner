package com.mitrai.ResourcePlanner.persistence.entity;

import javax.persistence.*;
import java.util.Set;


@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String refId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", 
		joinColumns = @JoinColumn(name = "user_id", referencedColumnName="id"), 
		inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName="id"))
	private Set<Role> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRefId() {
		return refId;
	}

	public void setRefId(String refId) {
		this.refId = refId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}