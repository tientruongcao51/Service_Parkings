package com.parking.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.parking.hibernate.entity.CarCard;
import com.parking.hibernate.service.CarCardService;
import com.parking.hibernate.service.CarCardService;

@RestController
public class CarCardController {
	@Autowired CarCardService CarCardService;
	
	@RequestMapping(value ="/getAllListCarCard", method = RequestMethod.GET, headers ="Accept=application/json")
	public List<CarCard> List() {
		List<CarCard> list = CarCardService.list();
		return list;
	}
	
	
	@RequestMapping(value ="/getListCarCard/first={first}&max={max}", method = RequestMethod.GET, headers ="Accept=application/json")
	public List<CarCard> getListCarCard(@PathVariable int first, @PathVariable int max) {
		List<CarCard> list = CarCardService.list(first, max);
		return list;
	}
	
	@RequestMapping(value = "/getCarCardById/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public CarCard getCarCardById(@PathVariable int id) {
		return CarCardService.getById(id);
	}
	
	@RequestMapping(value ="/addCarCard", method = RequestMethod.POST, headers ="Accept=application/json")
	public void addCarCard(@RequestBody CarCard carcard) {
		CarCardService.add(carcard);
	}
	
	@RequestMapping(value = "/updateCarCard", method = RequestMethod.PUT, headers = "Accept=application/json")
	public void updateCarCard(@RequestBody CarCard carcard) {
		CarCardService.update(carcard);
	}

	@RequestMapping(value = "/deleteCarCard/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteCarCard(@PathVariable("id") int id) {
		CarCardService.delete(id);	
	}
}
