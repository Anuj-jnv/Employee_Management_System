package com.example.demo.serviceImp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceImp implements EmployeeService {

	private final EmployeeRepository repository;

	public EmployeeServiceImp(EmployeeRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return repository.save(employee);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Employee Not Found"));
	}

	@Override
	public Employee updateEmployee(Long id, Employee employee) {

		Employee existing = repository.findById(id).orElseThrow(() -> new RuntimeException("Employee Not Found"));

		existing.setName(employee.getName());
		existing.setDepartmentName(employee.getDepartmentName());

		return repository.save(existing);
	}

	@Override
	public void deleteEmployee(Long id) {

		Employee existing = repository.findById(id).orElseThrow(() -> new RuntimeException("Employee Not Found"));

		repository.delete(existing);
	}
}