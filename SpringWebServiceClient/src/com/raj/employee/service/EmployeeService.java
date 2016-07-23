package com.raj.employee.service;

import java.util.List;

import com.raj.employee.dto.EmployeeDto;

public interface EmployeeService {
	
	/**
	 * @param dto
	 * @return
	 */
	public String saveOrUpdateEmployee(EmployeeDto dto);
	/**
	 * @return
	 */
	public List<EmployeeDto> getAllEmployee();
	/**
	 * @param id
	 * @return
	 */
	public EmployeeDto getEmployeeById(String id);
	/**
	 * @param id
	 * @return
	 */
	public String deleteEmployee(String id);
}
