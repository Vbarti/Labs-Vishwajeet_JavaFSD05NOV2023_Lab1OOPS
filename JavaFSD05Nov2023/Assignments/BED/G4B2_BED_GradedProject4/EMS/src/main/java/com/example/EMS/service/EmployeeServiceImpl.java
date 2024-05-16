// EmployeeServiceImpl.java
package com.example.EMS.service;

import com.example.EMS.model.Employee;
import com.example.EMS.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//EmployeeServiceImpl.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

 @Autowired
 private EmployeeRepository employeeRepository;

 @Override
 public Employee saveEmployee(Employee employee) {
     return employeeRepository.save(employee);
 }

 @Override
 public List<Employee> getAllEmployees() {
     return employeeRepository.findAll();
 }

 @Override
 public Employee getEmployeeById(Long id) {
     return employeeRepository.findById(id).orElse(null);
 }

 @Override
 public Employee updateEmployee(Employee employee) {
     return employeeRepository.save(employee);
 }

 @Override
 public void deleteEmployee(Long id) {
     employeeRepository.deleteById(id);
 }

 @Override
 public List<Employee> searchEmployeesByFirstName(String firstName) {
     return employeeRepository.findByFirstName(firstName);
 }

 @Override
 public List<Employee> getAllEmployeesSorted(String order) {
     Sort sort = Sort.by(order.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, "firstName");
     return employeeRepository.findAll(sort);
 }
}

