package com.parking.hibernate.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.parking.hibernate.entity.CarCard;

@Component
@Transactional
public class CarCardDao {
	@Autowired
	private SessionFactory sessionFactory;

	public List<CarCard> list() {
		String hql = "FROM CarCard";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	public List<CarCard> list(int first, int max) {
		String hql = "FROM CarCard";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult(first);
		query.setMaxResults(max);
		return query.list();
	}

	public CarCard getById(int id) {
		return (CarCard) sessionFactory.getCurrentSession().get(CarCard.class, id);
	}

	public void add(CarCard carcard) {
		sessionFactory.getCurrentSession().saveOrUpdate(carcard);
	}

	public void update(CarCard carcard) {
		sessionFactory.getCurrentSession().update(carcard);
	}

	public void delete(int id) {
		CarCard carcard = getById(id);
		sessionFactory.getCurrentSession().delete(carcard);
	}
}
