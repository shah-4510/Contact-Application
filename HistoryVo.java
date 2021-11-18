package com.ContactApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "History_table")
public class HistoryVo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "searchHistory")
	private String searchHistory;
	
	@Column(name = "date_search")
	private String dateSearch;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSearchHistory() {
		return searchHistory;
	}

	public void setSearchHistory(String searchHistory) {
		this.searchHistory = searchHistory;
	}

	public String getDateSearch() {
		return dateSearch;
	}

	public void setDateSearch(String dateSearch) {
		this.dateSearch = dateSearch;
	}
	
	
	
	
}
