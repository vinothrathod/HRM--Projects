package com.example.API.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="vehicleParking")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	@Column
	private int empid;
	@Column
	private String vehicle_name;
	@Column
	private String vehicle_number;
	@Column
	private String vehicle_type;
	@Column
	private String vehicle_colour;
	@Column
	private Boolean is_parked;
	@Column
	private String parking_slot;
	
    public Vehicle() {
		
	}

	public Vehicle(int id, int empid, String vehicle_name, String vehicle_number, String vehicle_type,
			String vehicle_colour, Boolean is_parked, String parking_slot) {
		super();
		this.id = id;
		this.empid = empid;
		this.vehicle_name = vehicle_name;
		this.vehicle_number = vehicle_number;
		this.vehicle_type = vehicle_type;
		this.vehicle_colour = vehicle_colour;
		this.is_parked = is_parked;
		this.parking_slot = parking_slot;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getVehicle_name() {
		return vehicle_name;
	}

	public void setVehicle_name(String vehicle_name) {
		this.vehicle_name = vehicle_name;
	}

	public String getVehicle_number() {
		return vehicle_number;
	}

	public void setVehicle_number(String vehicle_number) {
		this.vehicle_number = vehicle_number;
	}

	public String getVehicle_type() {
		return vehicle_type;
	}

	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}

	public String getVehicle_colour() {
		return vehicle_colour;
	}

	public void setVehicle_colour(String vehicle_colour) {
		this.vehicle_colour = vehicle_colour;
	}

	public Boolean getIs_parked() {
		return is_parked;
	}

	public void setIs_parked(Boolean is_parked) {
		this.is_parked = is_parked;
	}

	public String getParking_slot() {
		return parking_slot;
	}

	public void setParking_slot(String parking_slot) {
		this.parking_slot = parking_slot;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", empid=" + empid + ", vehicle_name=" + vehicle_name + ", vehicle_number="
				+ vehicle_number + ", vehicle_type=" + vehicle_type + ", vehicle_colour=" + vehicle_colour
				+ ", is_parked=" + is_parked + ", parking_slot=" + parking_slot + "]";
	}
}
