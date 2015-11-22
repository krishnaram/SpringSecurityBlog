package com.springsecurityblog.service;

/**
 * Author: Ramakrishna Panni
 * Interface: AccountService
 * Details: Service Interface for giving Skeleton of methods  
 */


import org.springframework.stereotype.Component;
import com.springsecurityblog.model.Employee;

@Component
public interface AccountService {
	public Employee findAccountByUsername(String username);
	public Employee findByOfficialEmailID(String offEmaiID);
	public Employee saveEmployee(Employee account);
	
}
