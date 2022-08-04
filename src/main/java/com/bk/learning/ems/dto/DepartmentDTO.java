/**
 * 
 */
package com.bk.learning.ems.dto;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Saideep
 * @param <EmployeeDTO>
 *
 */
@Getter @Setter 
@NoArgsConstructor
@JsonIgnoreProperties({"dept-id"})
@JsonPropertyOrder({"location", "name"})
public class DepartmentDTO implements Serializable {
	
	private static final long serialVersionUID = 4605971902546551665L;
	
	@JsonProperty("dept-id")
	private String deptId;
	
	private String name;
	
	private String location;
	
	private Set<EmployeeDTO> employees;
	
}
