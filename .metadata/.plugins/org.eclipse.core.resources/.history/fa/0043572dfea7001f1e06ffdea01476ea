package com.example.API.Controller;

import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;
import com.example.API.Model.Employee;
import com.example.API.Service.EmployeeService;
import com.example.API.dto.DateAndAge;

@CrossOrigin("*")
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	
   @GetMapping("/employees/list")
	public List<Employee> getAllEmployees() {
	   return empService.getAllEmployees();
	}

//	@PostMapping("/employees/add")
//	public Employee createEmployee(@RequestBody Employee employee) {
//		Employee addEmployee= empService.addEmployee(employee);
//		return addEmployee;
//	}

	@GetMapping("/employees/list/{id}")
	public Employee getEmployee(@PathVariable int id) {
		Employee employee = (empService.findById(id));

		return employee;
	}

	@PutMapping("/employees/update/{id}")
	public ResponseEntity<Employee> updateEmployeeByID(@PathVariable int id, @RequestBody Employee employeeDetails) {

		Employee updatedEmployee = empService.update(id, employeeDetails);

		return ResponseEntity.ok(updatedEmployee);
	}

//	@DeleteMapping("/employees/delete/")
//	public String deleteEmployee( @RequestParam int employeeId) {
//		return empService.delete(employeeId);
//	}
	
	/* image adding */

	@PostMapping("/employees/add")
	public ResponseEntity<Employee> addEmployee(@RequestParam("name") String name, String email, String password,
			String education, String skills, String dob, String date_of_join, int contact, String certification,
			String project, String role, String location, @RequestParam("image") MultipartFile imageFile)
			throws IOException {

		Employee employee = empService.saveEmployee(name, email, password, education, skills, dob, date_of_join,
				contact, certification, project, role, location, imageFile);
		return ResponseEntity.ok(employee);
	}

	@DeleteMapping("/employees/delete/{id}")
	public String deleteEmployeeById(@PathVariable("id") int id) {
		return empService.delete(id);
	}

	/* Home page API's */

	@GetMapping("/homepage/total_count")
	public Integer getTotalEmployeeCount() {

		return empService.getTotalEmployeeCount();
	}

	@GetMapping("/homepage/technical")
	public Integer getTotalEmployeetechnical() {

		return empService.getTotalEmployeeTechnical();
	}

	@GetMapping("/homepage/non_technical")
	public Integer getTotalEmployeeNon_technical() {

		return empService.getTotalEmployeeNon_Technical();
	}

	/* Home page Birthday */

	@GetMapping("/homepage/bday")

	public List<DateAndAge> getBdayCount() {

		return (List<DateAndAge>) empService.getBdayEmployees();
	}

	

	/* login page */

	@PostMapping("/employee/login")
	public boolean login(@RequestParam String email, @RequestParam String password) {
		boolean loginStatus = empService.login(email, password);

		System.out.println("email:" + email);
		System.out.println("password:" + password);

		return loginStatus;
	}

	
}
