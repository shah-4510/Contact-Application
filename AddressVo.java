package com.ContactApp.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS_Table")
public class AddressVo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Address_id")
	private int id;
	
	@Column(name = "Address_type")
	private String addressType;
	
	@Column(name = "Address")
	private String address;
	
	@Column(name = "City")
	private String city;
	
	@Column(name = "State")
	private String state;
	
	@Column(name = "Zip")
	private String zip;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Contact_id")
	private AddContactVo addContactVo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public AddContactVo getAddContactVo() {
		return addContactVo;
	}

	public void setAddContactVo(AddContactVo addContactVo) {
		this.addContactVo = addContactVo;
	}
	
	
	
	
}
