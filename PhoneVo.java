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
@Table(name = "PHONE_Table")
public class PhoneVo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Phone_id")
	private int id;
	
	@Column(name = "Phone_type")
	private String phoneType;
	
	@Column(name = "Area_code")
	private String areaCode;
	
	@Column(name = "Number")
	private String number;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Contact_id")
	private AddContactVo addContactVo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public AddContactVo getAddContactVo() {
		return addContactVo;
	}

	public void setAddContactVo(AddContactVo addContactVo) {
		this.addContactVo = addContactVo;
	}
	
	
	
	
	

}
