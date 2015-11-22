package com.springsecurityblog.service.impl;


/**
 * Author: Ramakrishna Panni
 * Class: AccountServiceImpl
 * Details: Created to implement Methods of Account Service Interface
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springsecurityblog.model.Employee;

import com.springsecurityblog.repo.AccountRepo;
import com.springsecurityblog.service.AccountService;

@Service
public class AccountServiceImpl implements  AccountService {
	
    
	@Autowired
	private AccountRepo accountRepo;
	
	
	public Employee findAccountByUsername(String username) {
		Employee account= accountRepo.findByEmployeeUserName(username);
		return account;	
	}

	public Employee findByOfficialEmailID(String offEmaiID) {
		Employee account= accountRepo.findByOfficialEmailID(offEmaiID);
		return account;	
	}

	public Employee saveEmployee(Employee account) {
		Employee member = accountRepo.save(account);
		return member;
	}


}
