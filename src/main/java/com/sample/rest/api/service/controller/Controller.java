package com.sample.rest.api.service.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sample.rest.api.service.entity.Account;
import com.sample.rest.api.service.repository.AccountRepository;



@RestController
@RequestMapping("/api")
public class Controller {
	// Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured SET DATASOURCE URL IN APP.PROPERTIES
	// Consider defining a bean of type 'com.sample.rest.api.repository.AccountRepository' in your configuration IF PACKAGE HIERACHY IS NOT SET RIGHT
	// Access denied for user 'restaccount'@'localhost' to database 'rest_table' CHECK DB URL PASSWORD AND USERNAME CONFIG
	// Field 'rest_tablecol' doesn't have a default value CHECK TABLE IN DB THERE'S AN EXTRA COLUMN
	@Autowired
	private AccountRepository accountRepository;
	
	// test
	@GetMapping(path="/hello-spring")
	public  String getHelloWorld() {
		return "Hello Spring boot";
	}
	
	// get all
	@GetMapping(path="/account-list")
	public List<Account> getAllAccounts() {
		
		return accountRepository.findAll();
	}
	
	// get by id
	@GetMapping(path="/account-id/{id}")
	public Account getAccountById(@PathVariable int id) {
		
		return accountRepository.findById(id).get();
	}
	
	// get by account name
	@GetMapping(path="/account-name/{accountName}")
	public List<Account> getAccountByAccountName(@PathVariable String accountName) {
		
		return accountRepository.findByAccountName(accountName);
	}
	
	// update
	@PutMapping(path="/account-list/{id}")
	public ResponseEntity<Account> updateAccount(@PathVariable int id, @RequestBody Account account) {
		Account accountUpdate = accountRepository.save(account);
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}
	
	// add
	@PostMapping(path="/account-list")
	public ResponseEntity<Void> addAccount(
			@RequestBody Account account) {
		Account addAccount = accountRepository.save(account);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(addAccount.getAccountId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	// delete
	@DeleteMapping(path="/account-list/{id}")
	public ResponseEntity<Void> deleteAccount(@PathVariable Integer id) {
		accountRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
