package com.bk.learning.ems.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "TBL_EMPLOYEE")
public class EmployeeEntity implements Serializable{
	
	private static final long serialVersionUID = 6981835867071401604L;

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull(message = "Name can not be null")
	@NotBlank(message = "Name can not be blank")
	@Column(name = "first_name", nullable = false, length = 50)
	private String firstName;
	
	@Column(name = "last_name", nullable = false, length = 50)
	private String lastName;
	
	@Email(message = "Invali email address")
	@Column(name = "email", unique = true, nullable = false, length = 50)
	private String email;
	
	@Min(value = 100, message = "Salary can not be less than 100")
	@Column(name = "salary", nullable = false)
	private int salary;
	
	@NotNull(message = "Designation can not be null")
	@NotBlank(message = "Designation can not be blank")
	@Column(name = "designation", nullable = false, length = 50)
	private String designation;
	
	//@PastOrPresent(message = "Hire date can not be future date")
	@Column(name = "hire_date", nullable = false)
	private Date hireDate;
//	
//	@ManyToOne
//	@JoinColumn(name = "dept_id")
//	private DepartmentEntity department;
//	
//	@ManyToOne
//	@JoinColumn(name = "manager_id")
//	private EmployeeEntity manager;
//	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "manager")
//	private Set<EmployeeEntity> subordinates;
	
	

	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}




	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}




	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}




	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}




	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}




	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}




	/**
	 * @return the salary
	 */
	public int getSalary() {
		return salary;
	}




	/**
	 * @param salary the salary to set
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}




	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}




	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}




	/**
	 * @return the hireDate
	 */
	public Date getHireDate() {
		return hireDate;
	}




	/**
	 * @param hireDate the hireDate to set
	 */
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}




//	/**
//	 * @return the department
//	 */
//	@JsonBackReference(value = "employee-department")
//	//TODO BugFix:add value to resolve - com.fasterxml.jackson.databind.JsonMappingException: Multiple back-reference properties with name 'defaultReference'
//	public DepartmentEntity getDepartment() {
//		return department;
//	}
//
//
//
//
//	/**
//	 * @param department the department to set
//	 */
//	public void setDepartment(DepartmentEntity department) {
//		this.department = department;
//	}
//
//
//
//
//	/**
//	 * @return the manager
//	 */
//	@JsonBackReference(value="manager-subordinates")
//	//TODO BugFix:add value to resolve - com.fasterxml.jackson.databind.JsonMappingException: Multiple back-reference properties with name 'defaultReference'
//	public EmployeeEntity getManager() {
//		return manager;
//	}
//
//
//
//
//	/**
//	 * @param manager the manager to set
//	 */
//	public void setManager(EmployeeEntity manager) {
//		this.manager = manager;
//	}
//
//
//
//
//	/**
//	 * @return the subordinates
//	 */
//	@JsonManagedReference(value="manager-subordinates")
//	//TODO BugFix:add value to resolve - com.fasterxml.jackson.databind.JsonMappingException: Multiple back-reference properties with name 'defaultReference'
//	public Set<EmployeeEntity> getSubordinates() {
//		return subordinates;
//	}
//
//
//
//
//	/**
//	 * @param subordinates the subordinates to set
//	 */
//	public void setSubordinates(Set<EmployeeEntity> subordinates) {
//		this.subordinates = subordinates;
//	}
//
//
//
//
//	@Override
//	public String toString() {
//		return "EmployeeEntity [id=" + id + ", firstName=" + firstName + 
//                ", lastName=" + lastName + ", email=" + email   + "]";
//	}
//	
}