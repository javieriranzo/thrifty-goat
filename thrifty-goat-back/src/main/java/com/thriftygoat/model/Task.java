package com.thriftygoat.model;

public class Task {

	private Long id; 
	private String name; 
	private String description; 
	private TaskCategory taskCategory;
	
	public Task() {}
	
	public Task(Long id, String name, String description, TaskCategory taskCategory) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.taskCategory = taskCategory;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TaskCategory getTaskCategory() {
		return taskCategory;
	}

	public void setTaskCategory(TaskCategory taskCategory) {
		this.taskCategory = taskCategory;
	} 
	
	
}
