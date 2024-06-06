package com.example.BankingApplicationBSM69.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.BankingApplicationBSM69.error.EmployeeNotFoundException;
import com.example.BankingApplicationBSM69.model.Employee;
import com.example.BankingApplicationBSM69.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("getData")
	//@ResponseBody
	public Employee test() {
		return new Employee(101, "Max", "max@gmail.com", 34567L);
	}
	
	@PostMapping("saveData")
	public Employee save(@RequestBody Employee emp) {
		if(emp != null) {
			Employee employee = employeeService.save(emp);
			System.out.println(emp.getId() + ", " + emp.getName() + ", " + emp.getEmail() + ", " + emp.getSalary() );
			return employee;
		} else {
			return emp;
		}
	}
	
	@GetMapping("getAllData")
	public List<Employee> getAllData() {
		
			List<Employee> employeeList = employeeService.getAll();
			//System.out.println(emp.getId() + ", " + emp.getName() + ", " + emp.getEmail() + ", " + emp.getSalary() );
			employeeList.forEach(e -> System.out.println(e));
			return employeeList;
	}
	
	@GetMapping("getById/{id}")
	public Employee getById(@PathVariable("id") Integer id) throws EmployeeNotFoundException {
		
			
			return employeeService.getById(id);
	}
	
	@DeleteMapping("deleteById/{id}")
	public String deleteById(@PathVariable("id") int id) {
		
			employeeService.delete(id);
			return "Employee deleted successfully";
	}
	
	@PutMapping("updateEmployee/{id}")
    public Employee updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee) throws EmployeeNotFoundException{
        return employeeService.updateEmployee(id, employee);
    }

	

}
