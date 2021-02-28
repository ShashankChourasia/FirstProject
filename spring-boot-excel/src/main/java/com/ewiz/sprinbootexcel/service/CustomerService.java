package com.ewiz.sprinbootexcel.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.ewiz.sprinbootexcel.excelimport.UserExcelImporter;
import com.ewiz.sprinbootexcel.model.Customer;
import com.ewiz.sprinbootexcel.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Scheduled(cron= "0 0 11 * * *")
	public void importFromExcel() {
		
		try{
		UserExcelImporter excelImporter=new UserExcelImporter();
		List<Customer> listCustomer= excelImporter.excelImport();
		customerRepository.saveAll(listCustomer);
		}
		catch(Exception e){
		System.out.println("Scheduling..........");
		}
	}

	public List<Customer> getAllCustomers(){
		//return topics;
		List<Customer> customers= new ArrayList<>();
		customerRepository.findAll()
		.forEach(customers::add);
		return customers;
	}
	
//	public Optional<Customer> getCustomerByName(String name){
//		return customerRepository.findById(name);
//	}  
}
