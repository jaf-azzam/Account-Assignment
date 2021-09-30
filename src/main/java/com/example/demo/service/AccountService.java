package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.account.Account;
import com.example.demo.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
	public void save(Account account) {
		accountRepository.save(account);
	}
	
	public List<Account> getAccounts() {
		
		return accountRepository.findAll();
	}
}
