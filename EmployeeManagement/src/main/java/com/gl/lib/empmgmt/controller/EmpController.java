package com.gl.lib.empmgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gl.lib.empmgmt.entity.Employee;
import com.gl.lib.empmgmt.service.EmpService;

@Controller
//@RequestMapping("/employees")
public class EmpController {
	@Autowired
	EmpService empService;
	
	public EmpController(EmpService empService) {
		super();
		this.empService = empService;
	}

	@GetMapping("/employees")
	public String getAllEmployees(Model model) {
		System.out.println("in the controller");
		List<Employee> employees = empService.findAll();
//		for (Employee employee : employees) {
//			System.out.println(employee.getF_name());
//		}
//		System.out.println("");
		model.addAttribute("employees", employees);
		return "employees-list";
	}

	@GetMapping("/addEmployee")
	public String createemployeeForm(Model model) {
		System.out.println("in add controller");

		// create employee object to hold employee form data
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "add-employee";
	}
	
	@PostMapping("/employees")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		System.out.println("in save controller");
		empService.save(employee);
		System.out.println("employee saved");
		return "redirect:/employees";
	}
	
	@GetMapping("/employees/edit/{id}")
	public String editemployeeForm(@PathVariable int id, Model model) {
		model.addAttribute("employee", empService.findByID(id));
		return "edit_employee";
	}
	
	@PostMapping("/employees/{id}")
	public String updateemployee(@PathVariable int id, @ModelAttribute("employee") Employee employee, Model model) {

		// get employee from database by id
		Employee existingEmployee = empService.findByID(id);
		existingEmployee.setId(id);
		existingEmployee.setF_name(employee.getF_name());
		existingEmployee.setL_name(employee.getL_name());
		existingEmployee.setEmail(employee.getEmail());

		// save updated employee object
		empService.updateEmployee(existingEmployee);
		return "redirect:/employees";
	}
	
	
	@GetMapping("/employees/{id}")
	public String deleteemployee(@PathVariable int id) {
		empService.deleteById(id);
		return "redirect:/employees";
	}

	
	

}
