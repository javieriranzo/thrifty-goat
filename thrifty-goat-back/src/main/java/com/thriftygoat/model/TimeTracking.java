package com.thriftygoat.model;

import java.util.Date;

public class TimeTracking {

	private Long id; 
	private Worker worker; 
	private Date date; 
	private Task task;
	
	public TimeTracking() {}
	
	public TimeTracking(Long id, Worker worker, Date date, Task task) {
		this.id = id;
		this.worker = worker;
		this.date = date;
		this.task = task;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	} 
	
}
