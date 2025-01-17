package com.example.API.Service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.API.Model.Vehicle;
import com.example.API.Repository.VehicleRepo;
import com.example.API.dto.VehicleDto;



import java.util.stream.Collectors;


@Service
public class VehicleService {


	@Autowired
	private VehicleRepo vehicleRepo;

	public List<Vehicle> getAllVehicles() {
		return vehicleRepo.findAll();
	}

	public Vehicle findById(int id) {
		Vehicle vehicle = (vehicleRepo.findById(id)).get();
		return vehicle;
	}
	
	 public Vehicle saveVehicle(Vehicle vehicle) {
	        return vehicleRepo.save(vehicle);
	    }

	public Vehicle updateVehicle(int id, Vehicle vehicleDetails) {
		 Vehicle vehicle = vehicleRepo.findById(id).get();
		 
//		 System.out.println("update: " + vehicle);
		 	vehicle.setEmpid(vehicleDetails.getEmpid());
		 	vehicle.setVehicle_name(vehicleDetails.getVehicle_name());
		    vehicle.setVehicle_number(vehicleDetails.getVehicle_number());
	        vehicle.setVehicle_type(vehicleDetails.getVehicle_type());
	        vehicle.setVehicle_colour(vehicleDetails.getVehicle_colour());
	        vehicle.setIs_parked(vehicleDetails.getIs_parked());
	        vehicle.setParking_slot(vehicleDetails.getParking_slot());
	        
//	        System.out.println("After update: " + vehicle);
	        return vehicleRepo.save(vehicle);

	}

	public String delete(int id) {
		vehicleRepo.deleteById(id);

		return "Deleted succesfully";
	}
	


	
	public List<VehicleDto> getParkingDetailsByEmail(String email) {
        List<Object[]> results = vehicleRepo.findParkingDetailsByEmail(email);

        return results.stream()
            .map(result -> new VehicleDto(
                (Boolean) result[0],   
                (String) result[1], 
                (String) result[2],
                null,null
               
            ))
            .collect(Collectors.toList());
    }
	
	

	
	public List<String> getParkingSlotVehicles() {
	    List<Object[]> results = vehicleRepo.findParkingSlotVehicles();
	    List<VehicleDto> parkedVehicles = new ArrayList<>();
	    List<String> list = new ArrayList<>(Arrays.asList("P1", "P2", "P3", "P4", "P5", "P6", "P7", "P8", "P9", "P10",
	    		"P11", "P12", "P13", "P14", "P15")); 

	    System.out.println("Available parking slots: " + list);
	    
	    for (Object[] result : results) {
	        String parking_slot = (String) result[0];
	        System.out.println("Checking parking slot: " + parking_slot);
	        
	        if (list.contains(parking_slot)) { 
	            parkedVehicles.add(new VehicleDto(null,null, parking_slot,null,null));
	            list.remove(parking_slot); 
	        }
	        else {
	            System.out.println("Parking slot " + parking_slot + " is not in the predefined list.");
	 
	      }
	    }

	    System.out.println("Remaining available parking slots: " + list);
	    return list;
	}


	
	 public void updateParkingStatuss(int id, boolean is_parked) {
	        vehicleRepo.updateParkingStatus(id, is_parked);
	    }
	 
	 
	 public List<VehicleDto> getAllParkedVehicles() {
	       
	        List<Object[]> results = vehicleRepo.findAllParkedVehicles();

	        List<VehicleDto> parkedVehicles = new ArrayList<>();
	        for (Object[] result : results) {
	            Boolean isParked = (Boolean) result[0]; 
	            String parkingSlot = (String) result[1]; 
	            String vehicleNumber = (String) result[2];
	            String empName = (String) result[3];
	            parkedVehicles.add(new VehicleDto(isParked, parkingSlot,vehicleNumber, empName, null));
	        }

	        return parkedVehicles;
	    }


	 
	

	public void updateParkingSlots(String email, Boolean is_parked, String parking_slot) {
		System.out.println("Updating parking status for vehicle with email: " + email);
	    System.out.println("Parking slot: " + parking_slot + ", Is parked: " + is_parked);
	    
        vehicleRepo.updateVehicleParkingSlots(is_parked, parking_slot, email);
        
        System.out.println("Parking status updated successfully for vehicle: " + email);
	}
}
