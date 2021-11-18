package com.ContactApp.dto;

public class AddContactDto {

	private int id;
	private String fn;
	private String mn;
	private String ln;
	
	private AddressVoDto addressVoDto;
	private PhoneVoDto phoneVoDto;
	private DateVoDto dateVoDto;
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
	public AddressVoDto getAddressVoDto() {
		return addressVoDto;
	}
	public void setAddressVoDto(AddressVoDto addressVoDto) {
		this.addressVoDto = addressVoDto;
	}
	public PhoneVoDto getPhoneVoDto() {
		return phoneVoDto;
	}
	public void setPhoneVoDto(PhoneVoDto phoneVoDto) {
		this.phoneVoDto = phoneVoDto;
	}
	public DateVoDto getDateVoDto() {
		return dateVoDto;
	}
	public void setDateVoDto(DateVoDto dateVoDto) {
		this.dateVoDto = dateVoDto;
	}
	
	
}
