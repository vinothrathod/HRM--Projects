package com.example.API.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.API.Model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> { 
	
  
    @Query( 
        nativeQuery = true, 
        value 
        = "SELECT COUNT(*) OVER() AS total_employees FROM hrm_table.employee;") 
    Integer findTotalEmployeeCount();

    
    @Query( 
            nativeQuery = true, 
            value 
            = "SELECT COUNT(*) OVER() AS technical_employees FROM hrm_table.employee emp where emp.role = 'technical' ;") 
           Integer findTotalEmployeeTechnical();


@Query( 
        nativeQuery = true, 
        value 
        = "SELECT COUNT(*) OVER() AS non_technical_employees FROM hrm_table.employee emp where emp.role = 'non-technical' ;") 
       Integer findTotalEmployeeNon_Technical();


	/*  To get Bday count  */

@Query( 
        nativeQuery = true, 
        value 
        = "Select name ,dob, profile FROM hrm_table.employee WHERE EXTRACT(MONTH FROM dob) = EXTRACT(MONTH FROM CURRENT_DATE) AND EXTRACT(DAY FROM dob) = EXTRACT(DAY FROM CURRENT_DATE); " )
        
		List<Object[]> findEmployeesWithTodayAsBirthday();	
	
	/*  login page  */	

		@Query(
			    value = "SELECT e.email, e.password FROM hrm_table.employee e WHERE e.email = :email",
			    nativeQuery = true
			)
			List<Object[]> getLoginStatus(@Param("email") String email);
}

//AND e.password = ' :password ' 
