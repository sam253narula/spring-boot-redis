package com.example.respository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.entity.Employee;

import java.util.List;

@Repository
public class EmployeeDao {

	public static final String HASH_KEY = "Employee";

	@Autowired
	private RedisTemplate template;

	public Employee save(Employee employee) {
		template.opsForHash().put(HASH_KEY, employee.getId(), employee);
		return employee;
	}

	public List<Employee> findAll() {
		return template.opsForHash().values(HASH_KEY);
	}

	public Employee findEmployeeById(int id) {
		return (Employee) template.opsForHash().get(HASH_KEY, id);
	}

	public String deleteEmployee(int id) {
		template.opsForHash().delete(HASH_KEY, id);
		return "employee removed !!";
	}
}
