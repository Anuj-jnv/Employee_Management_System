package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.serviceImp.EmployeeServiceImp;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	private final EmployeeServiceImp service;

	public EmployeeController(EmployeeServiceImp service) {
		this.service = service;
	}

	@GetMapping
	@Tag(name = "To get All Employee")
	public List<Employee> getAllEmployee() {
		return service.getAllEmployees();

	}

	@GetMapping("/{id}")
	@Tag(name = "To get an Employee By their Id")
	public Employee getEmployeeById(@PathVariable Long id) {
		return service.getEmployeeById(id);
	}

	@PostMapping
	@Tag(name = "To create Employee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}

	@PutMapping("/{id}")
	@Tag(name = "To Update Employee")
	public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		return service.updateEmployee(id, employee);
	}

	@DeleteMapping("/{id}")
	@Tag(name = "To delete Employee")
	public String deleteEmployee(@PathVariable Long id) {
		service.deleteEmployee(id);
		return "Employee Deleted Successfully";
	}

}
