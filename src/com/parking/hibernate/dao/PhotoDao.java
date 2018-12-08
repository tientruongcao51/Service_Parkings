package com.parking.hibernate.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.parking.hibernate.entity.Photo;

@Component
@Transactional
public class PhotoDao {
	@Autowired
	private SessionFactory sessionFactory;

	public List<Photo> list() {
		String hql = "FROM Photo";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	public List<Photo> list(int first, int max) {
		String hql = "FROM Photo";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult(first);
		query.setMaxResults(max);
		return query.list();
	}

	public Photo getById(int id) {
		return (Photo) sessionFactory.getCurrentSession().get(Photo.class, id);
	}

	public void add(Photo photo) {
		sessionFactory.getCurrentSession().saveOrUpdate(photo);
	}

	public void update(Photo photo) {
		sessionFactory.getCurrentSession().update(photo);
	}

	public void delete(int id) {
		Photo photo = getById(id);
		sessionFactory.getCurrentSession().delete(photo);
	}
}	
