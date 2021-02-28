package com.ewiz.sprinbootexcel.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ewiz.sprinbootexcel.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String> {
	
	List<Customer> findByAadharnumber(long aadharnumber);
	
	List<Customer> findByPannumber(String pannumber);
	
	List<Customer> findByUannumber(long uannumber);
}
