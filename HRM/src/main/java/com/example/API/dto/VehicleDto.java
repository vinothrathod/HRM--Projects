package com.example.API.dto;

public class VehicleDto {

	 private Boolean is_parked;
	 private String parking_slot;
	 private String vehicle_number;
	 private String empName;
	 private String email;
	 

	  
	    public VehicleDto() {
	    }

		public VehicleDto(Boolean is_parked, String parking_slot, String vehicle_number, String empName, String email) {
			super();
			this.is_parked = is_parked;
			this.parking_slot = parking_slot;
			this.vehicle_number = vehicle_number;
			this.empName = empName;
			
		}


		public Boolean getIs_Parked() {
			return is_parked;
		}


		public void setIs_Parked(Boolean is_Parked) {
			this.is_parked = is_Parked;
		}


		public String getParking_slot() {
			return parking_slot;
		}


		public void setParking_slot(String parking_slot) {
			this.parking_slot = parking_slot;
		}

		public String getVehicle_number() {
			return vehicle_number;
		}

		public void setVehicle_number(String vehicle_number) {
			this.vehicle_number = vehicle_number;
		}

		public String getEmpName() {
			return empName;
		}

		public void setEmpName(String empName) {
			this.empName = empName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
}
