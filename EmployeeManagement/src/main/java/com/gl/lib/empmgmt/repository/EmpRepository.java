package com.gl.lib.empmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.lib.empmgmt.entity.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer> {

}
