package com.mitrai.ResourcePlanner.persistence.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String refId;
	private String name;
	private String description;
	@ManyToMany(mappedBy = "roles")
	private Set<User> users;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "role_permission", 
		joinColumns = @JoinColumn(name = "role_id", referencedColumnName="id"), 
		inverseJoinColumns = @JoinColumn(name = "permission_id", referencedColumnName="id"))
	private Set<Permission> permissions;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}

}
