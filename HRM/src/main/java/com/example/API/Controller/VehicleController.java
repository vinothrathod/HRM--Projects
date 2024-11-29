package com.example.API.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.API.Model.Vehicle;
import com.example.API.Service.VehicleService;
import com.example.API.dto.VehicleDto;



@CrossOrigin("*")
@RestController
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	
	
   @GetMapping("/vehicles/list")
	public List<Vehicle> getAllVehicles() {
	   return vehicleService.getAllVehicles();
	}
     
   @GetMapping("/vehicles/list/{id}")
   public Vehicle getVehicle(@PathVariable int id) {
	   Vehicle vehicle = (vehicleService.findById(id));

		return vehicle;
	}
   
   @PostMapping("/vehicles/add")
   public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
	   System.out.println("Received vehicle: " + vehicle);
       return vehicleService.saveVehicle(vehicle);
   }
   
   
   @PutMapping("/vehicles/update/{id}")
   public ResponseEntity<Vehicle> updateVehicleByID(@PathVariable int id, @RequestBody Vehicle vehicleDetails) {
       Vehicle updatedVehicle = vehicleService.updateVehicle(id, vehicleDetails);
       return ResponseEntity.ok(updatedVehicle);
   }

   @DeleteMapping("/vehicles/delete/{id}")
   public String deleteVehicleById(@PathVariable int id) {
     return  vehicleService.delete(id);
   
   }
    
   
//   @DeleteMapping("/vehicles/delete/{id}")
//   public ResponseEntity<Void> deleteVehicle(@PathVariable int id) {
//       vehicleService.deleteVehicle(id);
//       return ResponseEntity.noContent().build();
//   }
   
   
//   @GetMapping("/vehicles/parking/{empId}")
//   public List<Object[]> getParkingDetails(@PathVariable int empId) {
//       return vehicleService.getParkingDetailsByEmpId(empId);
//   } 
   
//   @GetMapping("/vehicles/parking/{empId}")
//   public List<VehicleDto> getParkingDetails(@PathVariable int empId) {
//       return vehicleService.getParkingDetailsByEmpId(empId);
//   }
   
   @GetMapping("/vehicles/parking/slots")
   public List<VehicleDto> getParkingDetails(@RequestParam String email) {
       return vehicleService.getParkingDetailsByEmail(email);
   }
   
   
   
   @GetMapping("/vehicles/parking/parked")
   public List<String> getParkingSlotVehicles() {
       return vehicleService.getParkingSlotVehicles();
   }
   

   @PutMapping("/vehicles/parking/{id}")
   public void updateParkingStatus(@PathVariable int id, @RequestParam boolean is_parked) {
	    vehicleService.updateParkingStatuss(id, is_parked);
   }
   
  
   @GetMapping("/vehicles/parkedlist")
   public List<VehicleDto> getAllParkedVehicles() {
       return vehicleService.getAllParkedVehicles();
   }
   

   
  
//   @PutMapping("/vehicles/updateParking")
//  public String updateParkingStatus(int empId) {
//      vehicleService.updateParkingStatus(empId);
//      return "Parking status updated!";
//  }
	   
   @PutMapping("/vehicles/updateParking")
   public ResponseEntity<String> updateParkingSlots(    
           @RequestParam Boolean is_parked, 
           @RequestParam String parking_slot,
           @RequestParam String email) {
	   System.out.println("Email: " + email);
       System.out.println("Is Parked: " + is_parked);
       System.out.println("Parking Slot: " + parking_slot);
           vehicleService.updateParkingSlots(email, is_parked, parking_slot);
            return ResponseEntity.ok("Parking status updated successfully");
     
       }
}
