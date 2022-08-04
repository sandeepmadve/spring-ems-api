package com.bk.learning.ems.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bk.learning.ems.dto.EmployeeDTO;
import com.bk.learning.ems.entity.EmployeeEntity;
import com.bk.learning.ems.exception.BusinessException;
import com.bk.learning.ems.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	@GetMapping(path = "/home", produces = "application/json")
	public List<EmployeeDTO> adminHome() {
		return empService.empList();
	}
	
	@GetMapping(path = "/emp/list", produces = "application/json")
	public List<EmployeeDTO> getAllEmployees() {
		return empService.empList();
	}

	@GetMapping(path = "/emp/{id}", produces = "application/json")
	public EmployeeDTO getEmployeeById(@PathVariable("id") int empId) throws BusinessException {
		return empService.getEmpById(empId);
	}

	@PostMapping(path = "/emp/createEmployee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeEntity> createOrUpdateEmployee(@RequestBody EmployeeEntity entity)
			throws ParseException {
		EmployeeEntity employeeEntity = empService.createOrUpdateEmployee(entity);
		return new ResponseEntity<EmployeeEntity>(employeeEntity, HttpStatus.CREATED);
	}

}
