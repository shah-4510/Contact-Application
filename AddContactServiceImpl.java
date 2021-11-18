package com.ContactApp.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ContactApp.dao.AddContactDao;
import com.ContactApp.dto.AddContactDto;
import com.ContactApp.dto.AddressVoDto;
import com.ContactApp.dto.DateVoDto;
import com.ContactApp.dto.PhoneVoDto;
import com.ContactApp.model.AddContactVo;
import com.ContactApp.model.AddressVo;
import com.ContactApp.model.DateVo;
import com.ContactApp.model.HistoryVo;
import com.ContactApp.model.PhoneVo;

@Service
@Transactional
public class AddContactServiceImpl implements AddContactService{
	
	@Autowired
	private AddContactDao contactDao;

	public void saveContact(AddContactDto ContactDto) {
		
		AddContactVo addContactVo = new AddContactVo();
		addContactVo.setFn(ContactDto.getFn());
		addContactVo.setMn(ContactDto.getMn());
		addContactVo.setLn(ContactDto.getLn());
		addContactVo.setId(ContactDto.getId());
		this.contactDao.saveContact(addContactVo);
		
		AddressVo addressVo = new AddressVo();
		AddressVoDto addressVoDto = ContactDto.getAddressVoDto();
		addressVo.setAddContactVo(addContactVo);
		addressVo.setAddress(addressVoDto.getAddress());
		addressVo.setAddressType(addressVoDto.getAddressType());
		addressVo.setCity(addressVoDto.getCity());
		addressVo.setState(addressVoDto.getState());
		addressVo.setZip(addressVoDto.getZip());
		addressVo.setId(addressVoDto.getId());
		this.contactDao.saveAddress(addressVo);
		
		PhoneVo phoneVo = new PhoneVo();
		PhoneVoDto phoneVoDto = ContactDto.getPhoneVoDto();
		phoneVo.setAddContactVo(addContactVo);
		phoneVo.setAreaCode(phoneVoDto.getAreaCode());
		phoneVo.setNumber(phoneVoDto.getNumber());
		phoneVo.setPhoneType(phoneVoDto.getPhoneType());
		phoneVo.setId(phoneVoDto.getId());
		this.contactDao.savePhone(phoneVo);
		
		DateVo dateVo = new DateVo();
		DateVoDto dateVoDto = ContactDto.getDateVoDto();
		dateVo.setAddContactVo(addContactVo);
		dateVo.setContactDate(dateVoDto.getContactDate());
		dateVo.setDateType(dateVoDto.getDateType());
		dateVo.setId(dateVoDto.getId());
		this.contactDao.saveDate(dateVo);
		
	}

	public List<AddContactDto> viewContact(String queryString) {
		return this.contactDao.viewContact(queryString);
	}

	@Override
	public void deleteContact(AddContactVo addContactVo) {
		List<AddressVo> addressList = this.contactDao.editAddress(addContactVo.getId());
		List<DateVo> dateList = this.contactDao.editDate(addContactVo.getId());
		List<PhoneVo> phoneList = this.contactDao.editPhone(addContactVo.getId());
		
		
		this.contactDao.deleteAddress(addressList.get(0));
		this.contactDao.deleteDate(dateList.get(0));
		this.contactDao.deletePhone(phoneList.get(0));
		this.contactDao.deleteContact(addContactVo);
	}

	@Override
	public AddContactDto editContact(AddContactVo addContactVo) {
		List<AddressVo> addressList = this.contactDao.editAddress(addContactVo.getId());
		List<DateVo> dateList = this.contactDao.editDate(addContactVo.getId());
		List<PhoneVo> phoneList = this.contactDao.editPhone(addContactVo.getId());
		List<AddContactVo> contactList = this.contactDao.editContact(addContactVo.getId());
		
		AddContactVo addContactVo1 = contactList.get(0);
		AddressVo addressVo1 = addressList.get(0);
		PhoneVo phoneVo1 = phoneList.get(0);
		DateVo dateVo1 = dateList.get(0);
		
		
		
		AddressVoDto addressVoDto = new AddressVoDto();
		addressVoDto.setAddress(addressVo1.getAddress());
		addressVoDto.setAddressType(addressVo1.getAddressType());
		addressVoDto.setCity(addressVo1.getCity());
		addressVoDto.setState(addressVo1.getState());
		addressVoDto.setZip(addressVo1.getZip());
		addressVoDto.setId(addressVo1.getId());
		
		PhoneVoDto phoneVoDto = new PhoneVoDto();
		phoneVoDto.setAreaCode(phoneVo1.getAreaCode());
		phoneVoDto.setNumber(phoneVo1.getNumber());
		phoneVoDto.setPhoneType(phoneVo1.getPhoneType());
		phoneVoDto.setId(phoneVo1.getId());
		
		DateVoDto dateVoDto = new DateVoDto();
		dateVoDto.setContactDate(dateVo1.getContactDate());
		dateVoDto.setDateType(dateVo1.getDateType());
		dateVoDto.setId(dateVo1.getId());
		
		
		AddContactDto addContactDto = new AddContactDto();
		addContactDto.setAddressVoDto(addressVoDto);
		addContactDto.setDateVoDto(dateVoDto);
		addContactDto.setPhoneVoDto(phoneVoDto);
		addContactDto.setFn(addContactVo1.getFn());
		addContactDto.setMn(addContactVo1.getMn());
		addContactDto.setLn(addContactVo1.getLn());
		addContactDto.setId(addContactVo1.getId());
		return addContactDto;
	}
	
	public void saveHistory(HistoryVo historyVo){
		this.contactDao.saveHistory(historyVo);
	}

	@Override
	public List history() {
		return this.contactDao.history();
	}

}
