package com.ContactApp.controller;

import java.util.List;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ContactApp.dto.AddContactDto;
import com.ContactApp.model.AddContactVo;
import com.ContactApp.model.HistoryVo;
import com.ContactApp.service.AddContactService;

@Controller
public class AddContactController {
	
	@Autowired
	private AddContactService addContactService;
	
	@GetMapping(value = "/")
	public ModelAndView index() {
		
		return new ModelAndView("index");
	}
	
	@GetMapping(value = "addContact")
	public ModelAndView addContact() {
		
		return new ModelAndView("addContact", "ContactVo", new AddContactDto());
	}
	
	@GetMapping(value = "history")
	public ModelAndView history() {
		
		List historyList = this.addContactService.history();
		return new ModelAndView("history", "historyList", historyList);
	}


	@PostMapping(value = "saveContact")
	public ModelAndView saveContact(@ModelAttribute AddContactDto ContactDto) {
		
		this.addContactService.saveContact(ContactDto);
		return new ModelAndView("redirect:viewContact");
	}
	
	@GetMapping(value = "viewContact")
	public ModelAndView viewContact(@RequestParam(required = false)String queryString) {
		
		if(queryString != null && !queryString.isEmpty()){
			
			HistoryVo historyVo = new HistoryVo();
			historyVo.setSearchHistory(queryString);
			historyVo.setDateSearch(new Date().toString());
			
			this.addContactService.saveHistory(historyVo);
		}
		
		List<AddContactDto> ContactList = this.addContactService.viewContact(queryString);
		return new ModelAndView("viewContact","ContactList", ContactList).addObject("queryString", queryString);
	}
	
	@GetMapping(value= "deleteContact")
	public ModelAndView deleteContact(@RequestParam int id, AddContactVo addContactVo){
		addContactVo.setId(id);
		this.addContactService.deleteContact(addContactVo);
		return new ModelAndView("redirect:viewContact");
	}
	
	@GetMapping(value= "editContact")
	public ModelAndView editContact(@RequestParam int id, AddContactVo addContactVo){
		addContactVo.setId(id);
		AddContactDto addContactDto = this.addContactService.editContact(addContactVo);
		return new ModelAndView("addContact", "ContactVo", addContactDto);
	}

	

}
