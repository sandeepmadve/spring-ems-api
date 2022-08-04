/**
 * 
 */
package com.bk.learning.ems.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.bk.learning.ems.utility.PrefixedSequenceIdGenerator;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author Saideep
 *
 */
@Entity
@Table(name = "TBL_DEPARTMENT")
public class Department implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1533540712613978537L;

	@Id
	@GenericGenerator(
			name = "department_id_seq",
			strategy = "com.bk.learning.ems.utility.PrefixedSequenceIdGenerator",
			parameters = {
					@Parameter(name = PrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "10"),
					@Parameter(name = PrefixedSequenceIdGenerator.PREFIX_VALUE_PARAMETER, value = "DEPT_"),
					@Parameter(name = PrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%d")
			})
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_id_seq")
	private String id;
	
	@Column(name = "name", unique = true, nullable = false, length = 50)
	private String name;
	
	@Column(name = "location", unique = true, nullable = false, length = 50)
	private String location;
	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
//	private Set<EmployeeEntity> employees;
//	
//	
	

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the employees
	 */
//	@JsonManagedReference(value = "employee-department")
//	//TODO BugFix:add value to resolve - com.fasterxml.jackson.databind.JsonMappingException: Multiple back-reference properties with name 'defaultReference'
//	public Set<EmployeeEntity> getEmployees() {
//		return employees;
//	}
//
//	/**
//	 * @param employees the employees to set
//	 */
//	public void setEmployees(Set<EmployeeEntity> employees) {
//		this.employees = employees;
//	}
//	
	
}
