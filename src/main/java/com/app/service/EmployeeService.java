package com.app.service;

import java.util.List;

import com.app.pojos.Employee;

public interface EmployeeService {
	
	//get all employee details
	List<Employee> getAllEmpDetails();
	Employee addEmpDetails(Employee transientEmp);
	Employee deleteEmpDetails(Long empId);
	Employee fetchEmpdetails(Long emiId);
	Employee updateEmpDetails(Employee detachedEmp);

}
