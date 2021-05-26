package com.crud.pay.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.crud.pay.entity.Company;

@Component
public class CompanyRepository 
{

	private Map<Long, Company> map = new HashMap<>();
	
	public void save(Company company)
	{
		map.put(company.getId(), company);
	}
	
	public Company findById(Long id)
	{
		return map.get(id);
	}
	
	public List<Company> findAll()
	{
		return new ArrayList<Company>(map.values());
	}
	
}
