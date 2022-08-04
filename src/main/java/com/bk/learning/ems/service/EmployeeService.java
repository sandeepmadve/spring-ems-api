package com.bk.learning.ems.service;

import java.util.List;

import com.bk.learning.ems.dto.EmployeeDTO;
import com.bk.learning.ems.entity.EmployeeEntity;
import com.bk.learning.ems.exception.BusinessException;

public interface EmployeeService {

	List<EmployeeDTO> empList();

	EmployeeEntity createOrUpdateEmployee(EmployeeEntity entity);

	EmployeeDTO getEmpById(int empId) throws BusinessException;

}
