package com.springsecurityblog.model;

/**
 * Author: Ramakrishna Panni
 * Class: Employee
 * Details: Created for Employee Bean
 */

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity
@Table(name="tblemployee")
public class Employee   {
	//Primary key 
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="ntEmpID")
	private Long accountId;
	
	@Column(name="vcEmployeeUserName")
	private String employeeUserName;
	
	@Column(name="vcEmailIdOff")
	private String officialEmailID;
	
	@Column(name="vcEmailIdPer")
	private String permanentEmailID;

	@Column(name="vcEmployeeFirstName")
	private String firstName;
	
	@Column(name="vcEmployeeMiddleName")
	private String middleName;

	@Column(name="vcEmployeeLastName")
	private String lastName;
	
	@Column(name="vcPresentAdd")
	private String presentAdd;
	
	@Column(name="vcPermanentAdd")
	private String permanentAdd;
	
	@Column(name="vcHomePhoneNumber")
	private String homeNumber;

	@Column(name="vcOfficeNumber")
	private String officeNumber;

	@Column(name="vcSkills")
	private String skills;

	@Column(name="vcPassword")
	private String password;

	@Column(name="fsCV")
	private byte[] cvBlob;

	@Column(name="fsEmployeePic")
	private byte[] picBlob;
	
	//Joins of Employee Bean with Role Bean
	@OneToMany(targetEntity = Role.class, mappedBy = "employee",
			cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	private Set<Role> empRoles = new HashSet<Role>();
	
	public Long getAccountId() {
		return accountId;
	}


	public Set<Role> getEmpRoles() {
		return empRoles;
	}

	public void setEmpRoles(Set<Role> empRoles) {
		this.empRoles = empRoles;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getEmployeeUserName() {
		return employeeUserName;
	}

	public void setEmployeeUserName(String employeeUserName) {
		this.employeeUserName = employeeUserName;
	}

	public String getOfficialEmailID() {
		return officialEmailID;
	}

	public void setOfficialEmailID(String officialEmailID) {
		this.officialEmailID = officialEmailID;
	}

	public String getPermanentEmailID() {
		return permanentEmailID;
	}

	public void setPermanentEmailID(String permanentEmailID) {
		this.permanentEmailID = permanentEmailID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPresentAdd() {
		return presentAdd;
	}

	public void setPresentAdd(String presentAdd) {
		this.presentAdd = presentAdd;
	}

	public String getPermanentAdd() {
		return permanentAdd;
	}

	public void setPermanentAdd(String permanentAdd) {
		this.permanentAdd = permanentAdd;
	}

	public String getHomeNumber() {
		return homeNumber;
	}

	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
	}

	public String getOfficeNumber() {
		return officeNumber;
	}

	public void setOfficeNumber(String officeNumber) {
		this.officeNumber = officeNumber;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte[] getCvBlob() {
		return cvBlob;
	}

	public void setCvBlob(byte[] cvBlob) {
		this.cvBlob = cvBlob;
	}

	public byte[] getPicBlob() {
		return picBlob;
	}

	public void setPicBlob(byte[] picBlob) {
		this.picBlob = picBlob;
	}
	public Employee() {
	}
	 public Employee(Employee employee) {
	        this.accountId = employee.accountId;
	        this.firstName = employee.firstName;
	        this.lastName = employee.lastName;
	        this.officialEmailID = employee.officialEmailID;
	        this.password = employee.password;
	    }
}
