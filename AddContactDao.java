package com.ContactApp.dao;

import java.util.List;

import com.ContactApp.dto.AddContactDto;
import com.ContactApp.model.AddContactVo;
import com.ContactApp.model.AddressVo;
import com.ContactApp.model.DateVo;
import com.ContactApp.model.HistoryVo;
import com.ContactApp.model.PhoneVo;


public interface AddContactDao {

	void saveContact(AddContactVo ContactVO);
	
	List<AddContactDto> viewContact(String queryString);

	void saveAddress(AddressVo addressVo);

	void savePhone(PhoneVo phoneVo);

	void saveDate(DateVo dateVo);
	
	void deleteContact(AddContactVo ContactVO);
	
	void deleteAddress(AddressVo addressVo);

	void deletePhone(PhoneVo phoneVo);

	void deleteDate(DateVo dateVo);
	
	List editContact(int id);
	
	List editAddress(int id);
	
	List editPhone(int id);
	
	List editDate(int id);
	
	List history();
	
	void saveHistory(HistoryVo historyVo);
}
