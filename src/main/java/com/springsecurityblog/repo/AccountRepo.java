package com.springsecurityblog.repo;


/**
 * Author: Ramakrishna Panni
 * Interface: AccountRepo
 * Details: JPA repository methods for Employee Bean 
 */

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.springsecurityblog.model.Employee;



@Repository
	public interface AccountRepo extends JpaRepository<Employee, Integer>
	{
		public Employee findByEmployeeUserName(String employeeUserName);
		public Employee findByOfficialEmailID(String offEmaiID);
		public Employee save(Employee account);
	}


