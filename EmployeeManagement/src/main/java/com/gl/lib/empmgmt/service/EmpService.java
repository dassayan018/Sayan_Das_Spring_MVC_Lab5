package com.gl.lib.empmgmt.service;

import java.util.List;

import com.gl.lib.empmgmt.entity.Employee;

public interface EmpService {

	public List<Employee> findAll();

	public Employee findByID(int theId);

	public void save(Employee theEmp);

	public void deleteById(int theId);

}
