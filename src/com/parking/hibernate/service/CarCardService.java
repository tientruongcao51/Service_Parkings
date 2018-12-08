package com.parking.hibernate.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.hibernate.dao.CarCardDao;
import com.parking.hibernate.entity.CarCard;

@Service
public class CarCardService {
	@Autowired
	CarCardDao carCardDao;

	@Transactional
	public List<CarCard> list() {
		return carCardDao.list();
	}

	@Transactional
	public List<CarCard> list(int first, int max) {
		return carCardDao.list(first, max);
	}

	@Transactional
	public CarCard getById(int id) {
		return carCardDao.getById(id);
	}

	@Transactional
	public void add(CarCard cate) {
		carCardDao.add(cate);
	}

	public void update(CarCard catemember) {
		carCardDao.update(catemember);
	}

	@Transactional
	public void delete(int id) {
		carCardDao.delete(id);
	}
}
