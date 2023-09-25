package com.gl.lib.empmgmt.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.lib.empmgmt.entity.Employee;
import com.gl.lib.empmgmt.repository.EmpRepository;

@Service
public class EmpServiceImp implements EmpService {
	@Autowired
	EmpRepository empRepo;

	@Override
	public List<Employee> findAll() {
//		List<Employee>employees = empRepo.findAll();
//		for (Employee employee : employees) {
//			System.out.println(employee.getF_name());
//		}
		return empRepo.findAll();
	}

	@Override
	public Employee findByID(int theId) {
		Optional<Employee> result= empRepo.findById(theId);
		Employee theEmployee=null;
		if(result.isPresent())
		{
			theEmployee=result.get();
		}
		else
		{
			throw new RuntimeException("Didnot find the EmployeeID:"+ theId);
		}
		return theEmployee;
	}

	@Override
	public void save(Employee theEmp) {
		empRepo.save(theEmp);

	}

	@Override
	public void deleteById(int theId) {
		empRepo.deleteById(theId);

	}
	
	@Override
	public Employee updateEmployee(Employee employee) {
		return empRepo.save(employee);
	}

	

}
