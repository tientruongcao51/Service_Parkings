package com.parking.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.parking.hibernate.entity.Customer;
import com.parking.hibernate.service.CustomerService;



@RestController
public class CustomerController {
	
	@Autowired CustomerService CustomerService;
	
	@RequestMapping(value ="/getAllListCustomer", method = RequestMethod.GET, headers ="Accept=application/json")
	public List<Customer> List() {
		List<Customer> list = CustomerService.list();
		return list;
	}
	
	
	@RequestMapping(value ="/getListCustomer/first={first}&max={max}", method = RequestMethod.GET, headers ="Accept=application/json")
	public List<Customer> getListCustomer(@PathVariable int first, @PathVariable int max) {
		List<Customer> list = CustomerService.list(first, max);
		return list;
	}
	
	@RequestMapping(value = "/getCustomerById/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Customer getCustomerById(@PathVariable int id) {
		return CustomerService.getById(id);
	}
	
	@RequestMapping(value ="/addCustomer", method = RequestMethod.POST, headers ="Accept=application/json")
	public void addCustomer(@RequestBody Customer cate) {
		CustomerService.add(cate);
	}
	
	@RequestMapping(value = "/updateCustomer", method = RequestMethod.PUT, headers = "Accept=application/json")
	public void updateCustomer(@RequestBody Customer catemember) {
		CustomerService.update(catemember);
	}

	@RequestMapping(value = "/deleteCustomer/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteCustomer(@PathVariable("id") int id) {
		CustomerService.delete(id);	
	}

}
