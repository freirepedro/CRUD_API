package com.crud.pay.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.pay.entity.Company;
import com.crud.pay.repository.CompanyRepository;

@RestController
@RequestMapping(value = "/companies")
public class CompanyResource 
{
	
	@Autowired
	private CompanyRepository companyRepo = new CompanyRepository(); 

	@GetMapping
	public ResponseEntity<List<Company>> findAll()
	{	
		return ResponseEntity.ok().body(companyRepo.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Company> findById(@PathVariable Long id)
	{
		return ResponseEntity.ok().body(companyRepo.findById(id));
	}
	
}
