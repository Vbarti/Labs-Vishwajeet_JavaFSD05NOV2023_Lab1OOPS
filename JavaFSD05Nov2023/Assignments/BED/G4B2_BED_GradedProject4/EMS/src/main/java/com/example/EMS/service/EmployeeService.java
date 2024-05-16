// EmployeeService.java
package com.example.EMS.service;

import com.example.EMS.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    Employee updateEmployee(Employee employee);
    void deleteEmployee(Long id);
    List<Employee> searchEmployeesByFirstName(String firstName);
    List<Employee> getAllEmployeesSorted(String order);
}
