package com.spring_1.rest;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_1.entity.Employee;
import com.spring_1.service.EmployeeService;

@Controller
@RequestMapping("/api")
public class EmployeeController {
	private EmployeeService es;
	public EmployeeController(EmployeeService es) {
		this.es=es;
	}

	@GetMapping("/employees")
	public String allEmployees(Model model)
	{
		
		List<Employee> allemps = es.findAll();
		System.out.println("Fetched Employees: " + allemps);
		model.addAttribute("employees", allemps);
		return "employee-list";
		
	}
	@GetMapping("/showFormToAdd")
	public String showform(Model model)
	{
		// create model attribute to bind form data
		Employee emp = new Employee();
		model.addAttribute("employee", emp);
		return "employee-form";
	}
	@PostMapping("/save")
	public String saveEmp(@ModelAttribute("employee") Employee emp)
	{
		es.save(emp);
		return "redirect:/api/employees";
	}
	@GetMapping("/showFormToUpdate")
	public String showtoupdate(@RequestParam("empid") int id, Model model)
	{
	Employee emp = es.findById(id)	;
	model.addAttribute("employee", emp);
	return "employee-form";
	}
@GetMapping("/delete")
public String deleteEmployee(@RequestParam("empid") int id)
{
	
	es.deleteById(id);
	return "redirect:/api/employees";
}
}
