// EmployeeRepository.java
package com.example.EMS.repository;

import com.example.EMS.model.Employee;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findByFirstName(String firstName);
	Page<Employee> findByFirstNameContainingIgnoreCase(String firstName, Pageable pageable);
    Page<Employee> findAllByOrderByFirstNameAsc(Pageable pageable);
    Page<Employee> findAllByOrderByFirstNameDesc(Pageable pageable);
}

