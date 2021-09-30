package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.account.Account;
import com.example.demo.service.AccountService;

@RestController
public class AccountController {
	
	

	@Autowired
	AccountService accountService;
	
	
	@GetMapping("/account")  
	public List<Account> getAccount() {
		
		
		
		System.out.println("getting accounts. . . ");
		return accountService.getAccounts();
	}
	
	
	@PostMapping("account")
	public String addAccount(@RequestBody Account account) {
		if(account.equals(null))
			return "Cannot enter null values";
		
		accountService.save(account);
		return "Account successfully added !";
	}
}
