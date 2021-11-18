package com.ContactApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONTACT_Table")
public class AddContactVo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Contact_id")
	private int id;
	
	@Column(name = "Fname")
	private String fn;
	
	@Column(name = "Mname")
	private String mn;
	
	@Column(name = "Lname")
	private String ln;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFn() {
		return fn;
	}

	public void setFn(String fn) {
		this.fn = fn;
	}

	public String getMn() {
		return mn;
	}

	public void setMn(String mn) {
		this.mn = mn;
	}

	public String getLn() {
		return ln;
	}

	public void setLn(String ln) {
		this.ln = ln;
	}
	
	

}
