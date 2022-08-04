package com.bk.learning.ems.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO implements Serializable, Comparable<EmployeeDTO>{
	
	private static final long serialVersionUID = 5112827266228179177L;

	private Long empId;
	
	@NotNull(message = "Name can not be null")
	@NotBlank(message = "Name can not be blank")
	private String firstName;
	
	private String lastName;
	
	@Email(message = "Invali email address")
	private String email;
	
	@Min(value = 100, message = "Salary can not be less than 100")
	private int salary;
	
	@NotNull(message = "Designation can not be null")
	@NotBlank(message = "Designation can not be blank")
	private String designation;
	
	@PastOrPresent(message = "Hire date can not be future date")
	private Date hireDate;

//	private DepartmentDTO department;
//	
//	private EmployeeDTO manager;
//	
//	private Set<EmployeeDTO> subordinates;
	
	
	//For default sorting with emp id
	@Override
	public int compareTo(EmployeeDTO o) {
		if(this.getEmpId() < o.getEmpId())
			return -1;
		else if(this.getEmpId() > o.getEmpId())
			return 1;
		else
			return 0;
	}
}