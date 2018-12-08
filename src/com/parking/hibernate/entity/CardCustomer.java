package com.parking.hibernate.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "card_customer")
public class CardCustomer implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idCard")
	private CarCard card;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idCustomer")
	private Customer customer;

	@Column(name = "timeBorrowed")
	private Date timeBorrowed;

	@Column(name = "timeReturn")
	private Date timeReturn;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "cardCustomer")
	private Set<Photo> listPhoto = new HashSet<Photo>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CarCard getCard() {
		return card;
	}

	public void setCard(CarCard card) {
		this.card = card;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getTimeBorrowed() {
		return timeBorrowed;
	}

	public void setTimeBorrowed(Date timeBorrowed) {
		this.timeBorrowed = timeBorrowed;
	}

	public Date getTimeReturn() {
		return timeReturn;
	}

	public void setTimeReturn(Date timeReturn) {
		this.timeReturn = timeReturn;
	}

	public Set<Photo> getListPhoto() {
		return listPhoto;
	}

	public void setListPhoto(Set<Photo> listPhoto) {
		this.listPhoto = listPhoto;
	}

}
