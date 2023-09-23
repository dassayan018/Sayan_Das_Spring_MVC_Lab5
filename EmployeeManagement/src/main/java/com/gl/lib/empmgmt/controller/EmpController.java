package com.gl.lib.empmgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gl.lib.empmgmt.entity.Employee;
import com.gl.lib.empmgmt.service.EmpService;

@Controller
@RequestMapping("/employees")
public class EmpController {
	@Autowired
	EmpService empService;
	
	@GetMapping("/list")
	public String getAllEmployees(Model model) {
		List<Employee>employees = empService.findAll();
		model.addAttribute("employees", employees);
		return "employees/employees-list";
	}

}
