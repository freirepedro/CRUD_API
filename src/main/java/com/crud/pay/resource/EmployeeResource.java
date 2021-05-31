package com.crud.pay.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.pay.entity.Employee;
import com.crud.pay.repository.EmployeeRepository;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeResource 
{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping
	public ResponseEntity<Iterable<Employee>> findAll()
	{	
		return ResponseEntity.ok().body(employeeRepository.findAll());
	}
	
	@GetMapping(value = "/{id}/saldo")
	public double getSaldoFromCompany(@PathVariable Long id)
	{
		return employeeRepository.findById(id).get().getSaldo();
	}
	
	@GetMapping(value = "/save")
	public void registerCompany(Employee employee)
	{
		employeeRepository.save(employee);
	}
	
}
