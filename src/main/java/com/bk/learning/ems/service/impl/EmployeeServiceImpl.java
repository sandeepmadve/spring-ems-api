/**
 * 
 */
package com.bk.learning.ems.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bk.learning.ems.dto.EmployeeDTO;
import com.bk.learning.ems.entity.EmployeeEntity;
import com.bk.learning.ems.exception.BusinessException;
import com.bk.learning.ems.repository.EmployeeRepository;
import com.bk.learning.ems.service.EmployeeService;

import lombok.NoArgsConstructor;

/**
 * @author Saideep
 *
 */
@NoArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public List<EmployeeDTO> empList() {
		List<EmployeeEntity> dbData = empRepo.findAll();
		List<EmployeeDTO> result = dbData.stream().map(entity -> new EmployeeDTO(
				entity.getId(),
				entity.getFirstName(),
				entity.getLastName(),
				entity.getEmail(),
				entity.getSalary(),
				entity.getDesignation(),
				entity.getHireDate())).collect(Collectors.toList());
		return result;
	}

	@Override
	public EmployeeEntity createOrUpdateEmployee(EmployeeEntity entity) {

		if(entity.getId() == null) {
			//			entity.setHireDate(new Date());
			return empRepo.save(entity);	
		}else {
			Optional<EmployeeEntity> employee = empRepo.findById(entity.getId());
			if(employee.isPresent()) {
				EmployeeEntity newEntity = employee.get();
				newEntity.setFirstName(entity.getFirstName());
				newEntity.setLastName(entity.getLastName());
				newEntity.setEmail(entity.getEmail());
				newEntity.setSalary(entity.getSalary());
				newEntity.setHireDate(entity.getHireDate());

				return empRepo.save(newEntity);
			}else {
				return empRepo.save(entity);
			}
		}

	}

	@Override
	public EmployeeDTO getEmpById(int empId) throws BusinessException {
		Optional<EmployeeEntity> empOpt = empRepo.findById((long) empId); 
		if(empOpt.isPresent()) {
			return new EmployeeDTO(empOpt.get().getId(),
					empOpt.get().getFirstName(),
					empOpt.get().getLastName(),
					empOpt.get().getEmail(),
					empOpt.get().getSalary(),
					empOpt.get().getDesignation(),
					empOpt.get().getHireDate());
		}else {
			throw new EntityNotFoundException("Employee not found with id - "+ empId);
		}
	}

}
