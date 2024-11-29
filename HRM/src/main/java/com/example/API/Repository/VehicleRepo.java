package com.example.API.Repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;


import com.example.API.Model.Vehicle;



@Repository
public interface VehicleRepo extends JpaRepository<Vehicle, Integer> {

//	@Query("SELECT v.is_parked, v.parking_slot FROM Vehicle v WHERE v.empid = :empId")
//    List<Object[]> findParkingDetailsByEmpId(@Param("empId") int empId);
	
	  @Query(value = "SELECT vp.is_parked AS isParked, vp.parking_slot AS parkingSlot, vp.vehicle_number as vehicleNumber FROM hrm_table.vehicle_parking vp " +
              "LEFT JOIN hrm_table.employee e ON e.id = vp.empid " +
              "WHERE e.email = :email", nativeQuery = true)
	  List<Object[]> findParkingDetailsByEmail(@Param("email") String email);

	
	  @Query(value = "SELECT  vp.parking_slot FROM hrm_table.vehicle_parking vp WHERE vp.is_parked = true", nativeQuery = true)
	  List<Object[]> findParkingSlotVehicles();

	  
	  @Modifying
	  @Transactional
	@Query(value = "UPDATE hrm_table.vehicle_parking vp SET vp.is_parked = :is_parked WHERE vp.id = :id", nativeQuery = true)
	void updateParkingStatus( int id,  boolean is_parked);



	    @Query(value = "SELECT vp.is_parked AS isParked, "
	    		+ " vp.parking_slot AS parkingSlot, "
	    		+ " vp.vehicle_number as vehicleNumber, "
	    		+ " e.name as empName "
	    		+ " FROM hrm_table.vehicle_parking vp" 
	    		+ " LEFT JOIN hrm_table.employee e "
	    		+ "ON e.id = vp.empid "
	    		+ "where is_parked = true", nativeQuery = true)
	    List<Object[]> findAllParkedVehicles();


//	    @Modifying
//	    @Transactional
//	    @Query("UPDATE hrm_table.Vehicle_parking vp " +
//	           "JOIN hrm_table.employee e ON e.id = vp.empid " +
//	           "SET vp.is_parked = :is_parked, vp.parking_slot = :parking_slot " +
//	           "WHERE e.email = :email")
//	    void updateParkingStatusByEmail(@Param("isParked") boolean isParked, String parkingSlot, String email);


//	    @Modifying
//	    @Transactional
//	    @Query("UPDATE hrm_table.Vehicle_parking vp " 
//	    	   + "JOIN hrm_table.employee e ON e.id = vp.empid"
//	           + "SET vp.is_parked = :is_parked, "
//	           + "vp.parking_slot = :parking_slot " 
//	           + "WHERE e.id = :empId")
//	    void updateParkingStatus(@Param("empId") int empId);


	    
	    @Transactional
	    @Modifying
	    @Query(value = "UPDATE hrm_table.Vehicle_parking vp " +
	            "JOIN hrm_table.employee e ON e.id = vp.empid " +
	            "SET vp.is_parked = :is_parked, vp.parking_slot = :parking_slot " +
	            "WHERE e.email = :email", nativeQuery = true)
	   void updateVehicleParkingSlots(@Param("is_parked") Boolean is_parked,
	                                    @Param("parking_slot") String parking_slot,
	                                    @Param("email") String email);
	    
	 

}
