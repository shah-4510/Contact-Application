package com.ContactApp.service;

import java.util.List;

import com.ContactApp.dto.AddContactDto;
import com.ContactApp.model.AddContactVo;
import com.ContactApp.model.HistoryVo;


public interface AddContactService {
	
	public void saveContact(AddContactDto ContactDto);

	public List<AddContactDto> viewContact(String queryString);
	
	public void deleteContact(AddContactVo addContactVo);

	public AddContactDto editContact(AddContactVo addContactVo);
	
	public void saveHistory(HistoryVo historyVo);
	
	List history();

}
