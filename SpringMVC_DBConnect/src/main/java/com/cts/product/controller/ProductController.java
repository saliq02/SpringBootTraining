package com.cts.product.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cts.product.entity.Employee;
import com.cts.product.service.EmployeeService;

@Controller
public class ProductController {

	
	@Autowired
	private EmployeeService es;
	
	@RequestMapping("/")
	public String welcome() {
		return "index";
	}
	
	
	// List all employees from DB
	
	@RequestMapping("/findAll")
	public String findAll(Model empData) {
		List<Employee> emps=es.findAll();
		empData.addAttribute("employees", emps);
		return "employees";
	}
	
	// load employee dform 
	
	@RequestMapping("loadForm")
	public String loadForm() {
		return "employeeform";
	}
	
	@RequestMapping("saveEmployee")
	public void saveEmployee(@ModelAttribute("emp") Employee emp) {
	   System.out.println("--- Controller");
		es.saveEmployee(emp);
		
	}
	
	
	
	
	
}
