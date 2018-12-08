package com.parking.hibernate.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.hibernate.dao.CustomerDao;
import com.parking.hibernate.entity.Customer;

@Service
public class CustomerService {

	@Autowired
	CustomerDao categorymemberDao;

	@Transactional
	public List<Customer> list() {
		return categorymemberDao.list();
	}

	@Transactional
	public List<Customer> list(int first, int max) {
		return categorymemberDao.list(first, max);
	}

	@Transactional
	public Customer getById(int id) {
		return categorymemberDao.getById(id);
	}

	@Transactional
	public void add(Customer cate) {
		categorymemberDao.add(cate);
	}

	public void update(Customer catemember) {
		categorymemberDao.update(catemember);
	}

	@Transactional
	public void delete(int id) {
		categorymemberDao.delete(id);
	}

}
