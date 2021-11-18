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
@Table(name = "DATE_Table")
public class DateVo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Date_id")
	private int id;
	
	@Column(name = "Date_type")
	private String dateType;
	
	@Column(name = "Contact_date")
	private String contactDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Contact_id")
	private AddContactVo addContactVo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDateType() {
		return dateType;
	}

	public void setDateType(String dateType) {
		this.dateType = dateType;
	}

	public String getContactDate() {
		return contactDate;
	}

	public void setContactDate(String contactDate) {
		this.contactDate = contactDate;
	}

	public AddContactVo getAddContactVo() {
		return addContactVo;
	}

	public void setAddContactVo(AddContactVo addContactVo) {
		this.addContactVo = addContactVo;
	}

	
}
