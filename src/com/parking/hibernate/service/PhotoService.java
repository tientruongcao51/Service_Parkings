package com.parking.hibernate.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.hibernate.dao.PhotoDao;
import com.parking.hibernate.entity.Photo;

@Service
public class PhotoService {
	@Autowired
	PhotoDao photoDao;

	@Transactional
	public List<Photo> list() {
		return photoDao.list();
	}

	@Transactional
	public List<Photo> list(int first, int max) {
		return photoDao.list(first, max);
	}

	@Transactional
	public Photo getById(int id) {
		return photoDao.getById(id);
	}

	@Transactional
	public void add(Photo cate) {
		photoDao.add(cate);
	}

	public void update(Photo catemember) {
		photoDao.update(catemember);
	}

	@Transactional
	public void delete(int id) {
		photoDao.delete(id);
	}
}
