package com.sample.rest.api.service.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "rest_table")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Table 'bars_db.hibernate_sequence' doesn't exist IF NOT SET RIGHT
	@Column(name = "account_id")
	private int accountId;

	@Column(name = "account_name")
	private String accountName;

	@Column(name = "date_created")
	private LocalDateTime dateCreated;
	
	@Column(name = "is_active")
	private String isActive;
	
	@Column(name = "last_edited")
	private String lastEdited;

	public Account() {
		// no args
	}
	public Account(int accountId, String accountName, LocalDateTime dateCreated, String isActive, String lastEdited) {
		this.accountId = accountId;
		this.accountName = accountName;
		this.dateCreated = dateCreated;
		this.isActive = isActive;
		this.lastEdited = lastEdited;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getLastEdited() {
		return lastEdited;
	}

	public void setLastEdited(String lastEdited) {
		this.lastEdited = lastEdited;
	}

    
}
