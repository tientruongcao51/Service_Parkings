package com.parking.hibernate.entity;
// Generated Sep 26, 2018 6:04:22 AM by Hibernate Tools 5.3.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "phone")
	private String phone;
	@Column(name = "address")
	private String address;
	@Column(name = "carNumber")
	private String carNumber;
	@Column(name = "lastCheckIn")
	private Date lastCheckIn;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "customer")
	private Set<CardCustomer> listCardCustomer = new HashSet<CardCustomer>();

	public Customer() {
	}

	public Customer(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public Set<CardCustomer> getListCardCustomer() {
		return listCardCustomer;
	}

	public void setListCardCustomer(Set<CardCustomer> listCardCustomer) {
		this.listCardCustomer = listCardCustomer;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getLastCheckIn() {
		return lastCheckIn;
	}

	public void setLastCheckIn(Date lastCheckIn) {
		this.lastCheckIn = lastCheckIn;
	}
}
