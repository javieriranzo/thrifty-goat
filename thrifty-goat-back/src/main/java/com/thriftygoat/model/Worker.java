package com.thriftygoat.model;

import java.util.Date;

public class Worker {

	private Long id;
	private String firstName;
	private String lastName;
	private Date startDateAtWork;
	private String email;
	private String phoneNumber;
	private WorkerCategory workerCategory;

	public Worker() {
	}

	public Worker(Long id, String firstName, String lastName, Date startDateAtWork, String email, String phoneNumber,
			WorkerCategory jobTitle) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.startDateAtWork = startDateAtWork;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.workerCategory = jobTitle;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getStartDateAtWork() {
		return startDateAtWork;
	}

	public void setStartDateAtWork(Date startDateAtWork) {
		this.startDateAtWork = startDateAtWork;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public WorkerCategory getJobTitle() {
		return workerCategory;
	}

	public void setJobTitle(WorkerCategory jobTitle) {
		this.workerCategory = jobTitle;
	}

}
