package com.example.BankingApplicationBSM69.service;

import java.util.List;

import com.example.BankingApplicationBSM69.error.EmployeeNotFoundException;
import com.example.BankingApplicationBSM69.model.Employee;

public interface EmployeeService {
	
	public Employee save(Employee emp);
	
	public Employee getById(Integer id) throws EmployeeNotFoundException;
	
	public List<Employee> getAll();
	
	public void delete(Integer id);
	
	public Employee updateEmployee(Integer id, Employee employee) throws EmployeeNotFoundException;

}
