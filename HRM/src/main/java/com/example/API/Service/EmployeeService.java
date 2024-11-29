package com.example.API.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.API.Model.Employee;
import com.example.API.Repository.EmployeeRepo;
import com.example.API.dto.DateAndAge;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo empRepo;

	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}

//	public Employee addEmployee(Employee employee) {
//		Employee addEmployee= empRepo.save(employee);
//		return addEmployee;
//	}
	
	/* -----image adding------- */

	public Employee saveEmployee(String name, String email, String password, String education, String skills,
			String dob, String date_of_join, int contact, String certification, String project, String role,
			String location, MultipartFile file) throws IOException {
		Employee employee = new Employee();
		employee.setName(name);
		employee.setEmail(email);
		employee.setPassword(password);
		employee.setEducation(education);
		employee.setSkills(skills);
		employee.setDOB(dob);
		employee.setDate_of_join(date_of_join);
		employee.setContact(contact);
		employee.setProject(project);
		employee.setRole(role);
		employee.setLocation(location);
		employee.setCertification(certification);
		employee.setImage(file.getBytes());

		return empRepo.save(employee);
	}
	

	public Employee findById(int id) {
		Employee employee = (empRepo.findById(id)).get();
		return employee;
	}

	public Employee update(int id, Employee employeeDetails) {
		Employee employee = empRepo.findById(id).get();

		employee.setName(employeeDetails.getName());
		employee.setEmail(employeeDetails.getEmail());
		employee.setPassword(employeeDetails.getPassword());
		employee.setDOB(employeeDetails.getDOB());
		employee.setContact(employeeDetails.getContact());
		employee.setLocation(employeeDetails.getLocation());
		employee.setEducation(employeeDetails.getEducation());
		employee.setRole(employeeDetails.getRole());
		employee.setProject(employeeDetails.getProject());
		employee.setSkills(employeeDetails.getSkills());
		employee.setDate_of_join(employeeDetails.getDate_of_join());
		employee.setCertification(employeeDetails.getCertification());

		Employee updatedEmployee = empRepo.save(employee);

		return (updatedEmployee);
	}

	public String delete(int id) {
		empRepo.deleteById(id);

		return "Deleted succesfully";
	}

	/* -------Home page EmployeeCount------- */

	public Integer getTotalEmployeeCount() {
		Integer totalEmployeeCount = empRepo.findTotalEmployeeCount();
		return totalEmployeeCount;
	}

	public Integer getTotalEmployeeTechnical() {
		Integer totalEmployeeTechnical = empRepo.findTotalEmployeeTechnical();
		return totalEmployeeTechnical;
	}

	public Integer getTotalEmployeeNon_Technical() {
		Integer totalEmployeeNon_Technical = empRepo.findTotalEmployeeNon_Technical();
		return totalEmployeeNon_Technical;
	}

	/* -----Birthday details---- */

	public List<DateAndAge> getBdayEmployees() {
		List<Object[]> results = empRepo.findEmployeesWithTodayAsBirthday();
		List<DateAndAge> employeeDtos = new ArrayList<>();

		for (Object[] result : results) {
			String name = (String) result[0];
			// LocalDate dob = ((Date) result[1]).toInstant()
//                                              .atZone(ZoneId.systemDefault())
//                                              .toLocalDate();
			String dateString = (String) result[1];
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date date = formatter.parse(dateString);
				LocalDate dob = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//                System.out.println("LocalDate: " + dob);
//                System.out.println("DOB--------"+ dob);
				byte[] image = (byte[]) result[2];
				int age = calculateAge(dob);
				employeeDtos.add(new DateAndAge(name, dob, age, image));
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}

		return employeeDtos;
	}

	private int calculateAge(LocalDate dob) {
		return Period.between(dob, LocalDate.now()).getYears();
	}

	

	/* ---- Login Page ---- */

	public boolean login(String email, String password) {
		List<Object[]> dbData = empRepo.getLoginStatus(email);

		System.out.println("dbData:" + dbData);

		if (dbData == null || dbData.isEmpty()) {
			return false;

		} else {
			Object[] tempData = dbData.get(0);
			String savedEmail = (String) tempData[0];
			String savedPassword = (String) tempData[1];

			if (savedPassword.equals(password)) {
				return true;
			} else {
				return false;
			}
		}
	}
}
