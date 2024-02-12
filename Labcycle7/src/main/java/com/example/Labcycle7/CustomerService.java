package com.example.Labcycle7;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	public void addCustomer(String fname, String lname)
	{
		
		Customer customer = new Customer();
		customer.setFirstName(fname);
		customer.setLastName(lname);
		customerRepository.save(customer);
	}

	public List<Customer> getAllCustomers() 
	{
		return customerRepository.findAll();
	}
	
	public void updateCustomer(long id, String fname, String lname) 
	{
		Customer customer = customerRepository.findById(id).orElse(null);
		if (customer != null) 
		{
			customer.setFirstName(fname);
			customer.setLastName(lname);
			customerRepository.save(customer);
		}
	}
	public void deleteCustomer(long id) 
	{
		customerRepository.deleteById(id);
	}
			
}
