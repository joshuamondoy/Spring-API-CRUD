package com.sample.rest.api.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.rest.api.service.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{
	List<Account>findByAccountName(String accountName);
}
