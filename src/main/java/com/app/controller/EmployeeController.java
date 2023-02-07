package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.pojos.Employee;
import com.app.service.EmployeeService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	public EmployeeController() {
		System.out.println("in def ctor "+getClass());

	}
	
	@GetMapping
	public List<Employee> getAllEmps(){
		System.out.println("in get all emps");
		return empService.getAllEmpDetails();
	}
	
	@PostMapping
	public Employee saveEmpDetails(@RequestBody Employee transientEmp) {
		System.out.println("In save Emp" + transientEmp+" id "+transientEmp.getId());
		return empService.addEmpDetails(transientEmp);
		
	}
	
	@GetMapping("/{empId}")
	public Employee getEmpdetails(@PathVariable Long empId) {
		System.out.println("in get emp details"+empId);
		return empService.fetchEmpdetails(empId);
	}
	
	@PutMapping
	public Employee updateEmpdetails(@RequestBody Employee detachedEmp) {
		System.out.println("in update Emp"+detachedEmp);
		return empService.updateEmpDetails(detachedEmp);
	}
	
	@DeleteMapping("/{empId}")
	public Employee deleteEmpDetails(@PathVariable Long empId) {
		System.out.println("in del Emp"+empId);
		return empService.deleteEmpDetails(empId);
	}

}
