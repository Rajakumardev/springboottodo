package com.rajakumar.sample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Todo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String title;
	private String description;
	private String status;
	private String completed;
	
	public Todo() {
		super();
	}
	public Todo(String title,String description) {
		super();
		this.title = title;
		this.description = description;
		this.completed = "N";
		this.status = "new";
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCompleted() {
		return completed;
	}
	public void setCompleted(String completed) {
		this.completed = completed;
	}
}
