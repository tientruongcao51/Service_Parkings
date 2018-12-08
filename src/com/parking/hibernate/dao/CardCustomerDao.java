package com.parking.hibernate.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.parking.hibernate.entity.CardCustomer;

@Component
@Transactional
public class CardCustomerDao {
	@Autowired
	private SessionFactory sessionFactory;

	public List<CardCustomer> list() {
		String hql = "FROM CardCustomer";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	public List<CardCustomer> list(int first, int max) {
		String hql = "FROM CardCustomer";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult(first);
		query.setMaxResults(max);
		return query.list();
	}

	public CardCustomer getById(int id) {
		return (CardCustomer) sessionFactory.getCurrentSession().get(CardCustomer.class, id);
	}

	public void add(CardCustomer cardcustomer) {
		sessionFactory.getCurrentSession().saveOrUpdate(cardcustomer);
	}

	public void update(CardCustomer cardcustomer) {
		sessionFactory.getCurrentSession().update(cardcustomer);
	}

	public void delete(int id) {
		CardCustomer cardcustomer = getById(id);
		sessionFactory.getCurrentSession().delete(cardcustomer);
	}
}
