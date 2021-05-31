package com.crud.pay.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.pay.entity.Company;
import com.crud.pay.entity.Employee;
import com.crud.pay.repository.CompanyRepository;

@RestController
@RequestMapping(value = "/companies")
public class CompanyResource 
{
	
	@Autowired
	private CompanyRepository companyRepo; 

	@GetMapping
	public ResponseEntity<Iterable<Company>> findAll()
	{	
		return ResponseEntity.ok().body(companyRepo.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Company> findById(@PathVariable Long id)
	{
		return ResponseEntity.ok().body(companyRepo.findById(id).get());
	}
	
	@GetMapping(value = "/{id}/saldo")
	public double getSaldoFromCompany(@PathVariable Long id)
	{
		return companyRepo.findById(id).get().getSaldo();
	}
	
	@GetMapping(value = "/save")
	public void registerCompany(Company company)
	{
		companyRepo.save(company);
	}
	
	@GetMapping(value = "/{id}/salario")
	public void payEmployeeSalary(@PathVariable Long id)
	{
		
		Company company = companyRepo.findById(id).get();
		List <Employee> employees = company.getEmployees();
		int empSize = employees.size();
		
		for (int i = 0; i < empSize; i++)
		{
			
			Employee employee = employees.get(i);
			double salary = employees.get(i).getSalary();
			double salaryWithTax = employee.descontoTarifa(salary);
			double previousSaldo = employee.getSaldo();
			employee.setSaldo(previousSaldo + salaryWithTax); 
			company.setSaldo(company.getSaldo() - salaryWithTax);
			
		}
		
	}
}
