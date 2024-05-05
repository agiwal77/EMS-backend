package net.damon.ems.service;

import java.util.List;

import net.damon.ems.dto.EmployeeDto;

public interface EmployeeService {
	EmployeeDto createEmployee(EmployeeDto eomEmployeeDto);
	
	EmployeeDto getEmployeeById(Long id);
	
	List<EmployeeDto> getAllEmployees();
	
	EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto);
	
	void deleteEmployee(Long employeeId);
}
