package com.parking.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.parking.hibernate.entity.CardCustomer;
import com.parking.hibernate.service.CardCustomerService;
import com.parking.hibernate.service.CardCustomerService;

@RestController
public class CardCustomerController {
	@Autowired CardCustomerService CardCustomerService;
	
	@RequestMapping(value ="/getAllListCardCustomer", method = RequestMethod.GET, headers ="Accept=application/json")
	public List<CardCustomer> List() {
		List<CardCustomer> list = CardCustomerService.list();
		return list;
	}
	
	
	@RequestMapping(value ="/getListCardCustomer/first={first}&max={max}", method = RequestMethod.GET, headers ="Accept=application/json")
	public List<CardCustomer> getListCardCustomer(@PathVariable int first, @PathVariable int max) {
		List<CardCustomer> list = CardCustomerService.list(first, max);
		return list;
	}
	
	@RequestMapping(value = "/getCardCustomerById/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public CardCustomer getCardCustomerById(@PathVariable int id) {
		return CardCustomerService.getById(id);
	}
	
	@RequestMapping(value ="/addCardCustomer", method = RequestMethod.POST, headers ="Accept=application/json")
	public void addCardCustomer(@RequestBody CardCustomer cardcustomer) {
		CardCustomerService.add(cardcustomer);
	}
	
	@RequestMapping(value = "/updateCardCustomer", method = RequestMethod.PUT, headers = "Accept=application/json")
	public void updateCardCustomer(@RequestBody CardCustomer cardcustomer) {
		CardCustomerService.update(cardcustomer);
	}

	@RequestMapping(value = "/deleteCardCustomer/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteCardCustomer(@PathVariable("id") int id) {
		CardCustomerService.delete(id);	
	}
}
