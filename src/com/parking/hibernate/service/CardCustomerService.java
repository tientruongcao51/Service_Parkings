package com.parking.hibernate.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.hibernate.dao.CardCustomerDao;
import com.parking.hibernate.entity.CardCustomer;

@Service
public class CardCustomerService {
	@Autowired
	CardCustomerDao cardCustomerDao;

	@Transactional
	public List<CardCustomer> list() {
		return cardCustomerDao.list();
	}

	@Transactional
	public List<CardCustomer> list(int first, int max) {
		return cardCustomerDao.list(first, max);
	}

	@Transactional
	public CardCustomer getById(int id) {
		return cardCustomerDao.getById(id);
	}

	@Transactional
	public void add(CardCustomer cate) {
		cardCustomerDao.add(cate);
	}

	public void update(CardCustomer catemember) {
		cardCustomerDao.update(catemember);
	}

	@Transactional
	public void delete(int id) {
		cardCustomerDao.delete(id);
	}
}
