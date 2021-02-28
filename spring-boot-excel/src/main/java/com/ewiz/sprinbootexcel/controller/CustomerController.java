package com.ewiz.sprinbootexcel.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ewiz.sprinbootexcel.model.Customer;
import com.ewiz.sprinbootexcel.repository.CustomerRepository;
import com.ewiz.sprinbootexcel.service.CustomerService;

@RestController
@RequestMapping("/ewiz")
public class CustomerController {
	
	@Autowired
	private CustomerService customerservice;
	
	@Autowired
	CustomerRepository repository;
	
	 
	
	@RequestMapping("/home")
	public String homePage() {
		return "HomePage";
	}
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		return customerservice.getAllCustomers();
	}
	
	@GetMapping("/customer/name/{name}")
	public Optional<Customer> getCustomer(@PathVariable String name){
		return repository.findById(name);
	}
	
	@GetMapping("/customer/pannumber/{pannumber}")
	public List<Customer> getCustomerByPanNumber(@PathVariable String pannumber){
		return repository.findByPannumber(pannumber);
	}
	
	@GetMapping("/customer/aadharnumber/{aadharnumber}")
	public List<Customer> getCustomerByAadharNumber(@PathVariable Long aadharnumber){
		return repository.findByAadharnumber(aadharnumber);
	}
	
	@GetMapping("/customer/uannumber/{uannumber}")
	public List<Customer> getCustomerByUanNumber(@PathVariable Long uannumber){
		return repository.findByUannumber(uannumber);
	}

}