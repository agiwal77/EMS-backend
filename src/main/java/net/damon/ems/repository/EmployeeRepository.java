package net.damon.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.damon.ems.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
