package net.kammo.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.kammo.ems.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
