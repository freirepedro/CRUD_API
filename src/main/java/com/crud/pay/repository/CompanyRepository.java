package com.crud.pay.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.crud.pay.entity.Company;

@Component
public interface CompanyRepository extends CrudRepository<Company, Long>
{

	
	
}
