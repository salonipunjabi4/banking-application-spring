package com.example.BankingApplicationBSM69.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BankingApplicationBSM69.error.EmployeeNotFoundException;
import com.example.BankingApplicationBSM69.model.Employee;
import com.example.BankingApplicationBSM69.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee save(Employee emp) {
		// TODO Auto-generated method stub
		if(emp!=null) {
			employeeRepository.save(emp);
		}
		return emp;
	}

	@Override
	public Employee getById(Integer id) throws EmployeeNotFoundException {
		// TODO Auto-generated method stub
		Optional<Employee> employee = employeeRepository.findById(id);
        if(!employee.isPresent())
        {
            throw new EmployeeNotFoundException("Employee Not Available");
        }
        return employee.get();
	}

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}

	@Override
	public Employee updateEmployee(Integer id, Employee employee) throws EmployeeNotFoundException {
		// TODO Auto-generated method stub
		Employee empDB = employeeRepository.findById(id).get();
		
		if(empDB == null)
        {
            throw new EmployeeNotFoundException("Employee Not Available");
        }
		
		if(Objects.nonNull(employee.getName()) && !"".equals(employee.getName())) {
			empDB.setName(employee.getName());
		}
		if(Objects.nonNull(employee.getEmail()) && !"".equals(employee.getEmail()) ) {
			empDB.setEmail(employee.getEmail());
		}
		if(Objects.nonNull(employee.getSalary()) && !"".equals(employee.getSalary()) ) {
			empDB.setSalary(employee.getSalary());
		}
		return employeeRepository.save(empDB);
	}

}
