package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;
import com.example.respository.EmployeeDao;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeDao dao;

	@PostMapping
	public Employee save(@RequestBody Employee employee) {
		return dao.save(employee);
	}

	@GetMapping
	public List<Employee> getAllEmployees() {
		return dao.findAll();
	}

	@GetMapping("/{id}")
	public Employee findEmployee(@PathVariable int id) {
		return dao.findEmployeeById(id);
	}

	@DeleteMapping("/{id}")
	public String remove(@PathVariable int id) {
		return dao.deleteEmployee(id);
	}
}
