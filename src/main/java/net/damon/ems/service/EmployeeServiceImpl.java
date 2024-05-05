package net.damon.ems.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.damon.ems.dto.EmployeeDto;
import net.damon.ems.entity.Employee;
import net.damon.ems.exception.ResourceNotFoundException;
import net.damon.ems.mapper.EmployeeMapper;
import net.damon.ems.repository.EmployeeRepository;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		return EmployeeMapper.mapToEmployeeDto(employeeRepository.save(employee));
	}

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with given id: " + employeeId));
		return EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll().stream().map(employee -> EmployeeMapper.mapToEmployeeDto(employee))
				.toList();
	}

	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with given id: " + employeeId));

		employee.setFirstName(employeeDto.getFirstName());
		employee.setLastName(employeeDto.getLastName());
		employee.setEmail(employeeDto.getEmail());

		Employee updatedEmployee = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		// TODO Auto-generated method stub
		employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with given id: " + employeeId));

		employeeRepository.deleteById(employeeId);

	}

}
