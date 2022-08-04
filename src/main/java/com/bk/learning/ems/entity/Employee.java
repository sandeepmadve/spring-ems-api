package com.bk.learning.ems.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bk.learning.ems.Gender;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "employees")
public class Employee implements Serializable{
	
	private static final long serialVersionUID = 6981835867071401604L;

	@Id
	@GeneratedValue
	@Column(name = "emp_no", nullable = false)
	private Integer empNo;
	
	@Column(name = "birth_date", nullable = false)
	private Date birthDate;
	
	@Column(name = "first_name", nullable = false, length = 14)
	private String firstName;
	
	@Column(name = "last_name", nullable = false, length = 16)
	private String lastName;
	
	@Column(name = "gender", nullable = false)
	private String gender;
	
	@Column(name = "hire_date", nullable = false)
	private Date hireDate;
		
	
	
	
	
//	@Email(message = "Invali email address")
//	@Column(name = "email", unique = true, nullable = false, length = 50)
//	private String email;
//	
//	@Min(value = 100, message = "Salary can not be less than 100")
//	@Column(name = "salary", nullable = false)
//	private int salary;
//	
//	@NotNull(message = "Designation can not be null")
//	@NotBlank(message = "Designation can not be blank")
//	@Column(name = "designation", nullable = false, length = 50)
//	private String designation;
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