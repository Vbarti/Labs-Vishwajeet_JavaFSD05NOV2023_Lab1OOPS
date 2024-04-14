package com.example.employeemgmtsystem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.example.employeemgmtsystem")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}













///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
// */
//package com.example.employee.management.system;
//import org.springframework.data.jpa.repository.JpaRepository;
//
///**
// *
// * @author Vishwajeet.Bharti
// */
//public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//}
