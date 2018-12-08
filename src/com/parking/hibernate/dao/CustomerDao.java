package com.parking.hibernate.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.parking.hibernate.entity.Customer;

@Component
@Transactional
public class CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Customer> list() {
		String hql = "FROM Customer";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	public List<Customer> list(int first, int max) {
		String hql = "FROM Customer";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult(first);
		query.setMaxResults(max);
		return query.list();
	}

	public Customer getById(int id) {
		return (Customer) sessionFactory.getCurrentSession().get(Customer.class, id);
	}

	public void add(Customer cate) {
		sessionFactory.getCurrentSession().saveOrUpdate(cate);
	}

	public void update(Customer catemember) {
		sessionFactory.getCurrentSession().update(catemember);
	}

	public void delete(int id) {
		Customer cate = getById(id);
		sessionFactory.getCurrentSession().delete(cate);
	}

}
