package com.example.API.dto;

import java.util.Date;

public class EmployeeDto {

	private int id;
	private String Name;
	private String Email;
	private String Password;
	private Date DOB;
	private int Contact;
	private String Location;
	private String Education;
	private String Role;
	private String Project;
	private String Skills;
	private Date Date_of_join;
	private String Certification;
	
	public EmployeeDto() {
		
	}

	public EmployeeDto(int id, String name, String email, String password,  Date dOB, int contact, String location, String education,
			String role, String project, String skills, Date date_of_join, String certification) {
		super();
		this.id = id;
		Name = name;
		Email = email;
		Password = password;
		DOB = dOB;
		Contact = contact;
		Location = location;
		Education = education;
		Role = role;
		Project = project;
		Skills = skills;
		Date_of_join = date_of_join;
		Certification = certification;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public int getContact() {
		return Contact;
	}

	public void setContact(int contact) {
		Contact = contact;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getEducation() {
		return Education;
	}

	public void setEducation(String education) {
		Education = education;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public String getProject() {
		return Project;
	}

	public void setProject(String project) {
		Project = project;
	}

	public String getSkills() {
		return Skills;
	}

	public void setSkills(String skills) {
		Skills = skills;
	}

	public Date getDate_of_join() {
		return Date_of_join;
	}

	public void setDate_of_join(Date date_of_join) {
		Date_of_join = date_of_join;
	}

	public String getCertification() {
		return Certification;
	}

	public void setCertification(String certification) {
		Certification = certification;
	}
}
