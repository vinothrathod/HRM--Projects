package com.example.API.dto;

import java.time.LocalDate;

public class DateAndAge {

	private String name;
    private LocalDate dob;
    private int age;
    private byte[] image;

 
    public DateAndAge(String name, LocalDate dob, int age, byte[] image) {
		super();
		this.name = name;
		this.dob = dob;
		this.age = age;
		this.image = image;
	}

   
	public String getName() {
        return name;
    }
	
    public LocalDate getdob() {
        return dob;
    }

    public int getAge() {
        return age;
    }

	public byte[] getImage() {
		return image;
	}

}
