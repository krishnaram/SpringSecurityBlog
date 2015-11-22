package com.springsecurityblog.model;

/** Author: Ramakrishna Panni
* Class: Role
* Details: Created for Employee Role Bean
*/

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "tblemproles")
public class Role implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="ntEmpRoleID")
	private Long roleId;
	
	@Column(name="ntEmpID")
	private Long accountId;
	
	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	@Column(name="vcRole")
	private String role;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}



	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	//Here Role Bean is Joined with Employee Bean
	@ManyToOne
	@JoinColumn(name="ntEmpID", referencedColumnName = "ntEmpID", insertable = false, updatable = false)
	@JsonBackReference
	private Employee employee;
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.role;
	}
	public Role() {
	}
	public Role(Role employeeRole) {
	        this.role = employeeRole.role;
	        this.accountId =  employeeRole.accountId;
	   
	    }

}
