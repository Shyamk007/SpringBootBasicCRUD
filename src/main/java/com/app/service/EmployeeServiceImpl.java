package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.customExceptions.ResourceNotFoundException;
import com.app.pojos.Employee;
import com.app.repository.EmployeeRepository;



@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository empRepo;
	
	
	@Override
	public List<Employee> getAllEmpDetails() {
		return empRepo.findAll();	
	
	}


	@Override
	public Employee addEmpDetails(Employee transientEmp) {
		return empRepo.save(transientEmp);
	}


	@Override
	public Employee deleteEmpDetails(Long empId) {
		//we have to check whether the employee exists or not
		if(empRepo.existsById(empId)) {
			empRepo.deleteById(empId);
			return null;
		}
		throw new ResourceNotFoundException("Enter valid empId deleting employee failed");
	}


	@Override
	public Employee fetchEmpdetails(Long emiId) {
		return empRepo.findById(emiId).orElseThrow(()-> new ResourceNotFoundException("Invlid Emp Id"));
	}


	@Override
	public Employee updateEmpDetails(Employee detachedEmp) {
		//first check whether the employee exists or not
		if(empRepo.existsById(detachedEmp.getId())) {
			return empRepo.save(detachedEmp);
		}
		throw new ResourceNotFoundException("Invalid Emp Id");
	}

}
