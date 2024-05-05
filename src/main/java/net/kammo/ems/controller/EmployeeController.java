package net.kammo.ems.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.kammo.ems.dto.EmployeeDto;
import net.kammo.ems.service.EmployeeService;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private EmployeeService employeeService;
	
	@PostMapping(path = "/create")
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
		EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/get/{id}")
	public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") Long id){
		EmployeeDto employeeDto = employeeService.getEmployeeById(id);
		return new ResponseEntity<EmployeeDto>(employeeDto, HttpStatus.OK);
	}
	
	@GetMapping(path = "getAll")
	public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
		List<EmployeeDto> listOfEmployees = employeeService.getAllEmployees();
		return ResponseEntity.ok(listOfEmployees);
	}
	
	@PutMapping(path = "/update/{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,
			@RequestBody EmployeeDto employeeDto){
		EmployeeDto updatedEmployee = employeeService.updateEmployee(employeeId, employeeDto);
		return ResponseEntity.ok(updatedEmployee);
		
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
		employeeService.deleteEmployee(employeeId);
		return ResponseEntity.ok("Employee is deleted successfully!.");
	}
}
