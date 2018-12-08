package com.parking.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.parking.hibernate.entity.Customer;
import com.parking.hibernate.entity.Photo;
import com.parking.hibernate.service.CustomerService;
import com.parking.hibernate.service.PhotoService;

@RestController
public class PhotoController {
	@Autowired PhotoService PhotoService;
	
	@RequestMapping(value ="/getAllListPhoto", method = RequestMethod.GET, headers ="Accept=application/json")
	public List<Photo> List() {
		List<Photo> list = PhotoService.list();
		return list;
	}
	
	
	@RequestMapping(value ="/getListPhoto/first={first}&max={max}", method = RequestMethod.GET, headers ="Accept=application/json")
	public List<Photo> getListPhoto(@PathVariable int first, @PathVariable int max) {
		List<Photo> list = PhotoService.list(first, max);
		return list;
	}
	
	@RequestMapping(value = "/getPhotoById/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Photo getPhotoById(@PathVariable int id) {
		return PhotoService.getById(id);
	}
	
	@RequestMapping(value ="/addPhoto", method = RequestMethod.POST, headers ="Accept=application/json")
	public void addPhoto(@RequestBody Photo photo) {
		PhotoService.add(photo);
	}
	
	@RequestMapping(value = "/updatePhoto", method = RequestMethod.PUT, headers = "Accept=application/json")
	public void updatePhoto(@RequestBody Photo photo) {
		PhotoService.update(photo);
	}

	@RequestMapping(value = "/deletePhoto/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deletePhoto(@PathVariable("id") int id) {
		PhotoService.delete(id);	
	}
}
