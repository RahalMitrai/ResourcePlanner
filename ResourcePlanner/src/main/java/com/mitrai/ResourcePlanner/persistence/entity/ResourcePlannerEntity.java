package com.mitrai.ResourcePlanner.persistence.entity;

import javax.persistence.*;

@Entity
public class ResourcePlannerEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String title;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@ManyToOne
	@JoinColumn
	private EntityType entityType;

}