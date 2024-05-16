// EmployeeRepository.java
package com.example.EMS.repository;

import com.example.EMS.model.Employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findByFirstName(String firstName);
}

