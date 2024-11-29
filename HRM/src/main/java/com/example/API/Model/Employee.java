package com.example.API.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	
	@Column(name="name")
	private String Name;
	@Column(name="email")
	private String Email;
	@Column(name="password")
	private String Password;
	@Column
	private String DOB;
	@Column
	private int Contact;
	@Column
	private String Location;
	@Column
	private String Education;
	@Column
	private String Role;
	@Column
	private String Project;
	@Column
	private String Skills;
	@Column
	private String Date_of_join;
	@Column
	private String Certification;
	
	@Lob
    @Column(name = "profile", length = 3000)
    private byte[] Image;
	

	public Employee() {
		
	}

	public Employee(int id, String name, String email, String password, String dOB, int contact, String location, String education,
			String role, String project, String skills, String date_of_join, String certification,byte[] image) {
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
		this.Image = image;
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

	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dob) {
		DOB = dob;
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

	public String getDate_of_join() {
		return Date_of_join;
	}

	public void setDate_of_join(String date_of_join) {
		Date_of_join = date_of_join;
	}

	public String getCertification() {
		return Certification;
	}

	public void setCertification(String certification) {
		Certification = certification;
	}

	public byte[] getImage() {
		return Image;
	}

	public void setImage(byte[] image) {
		this.Image = image;
	}
}
