/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.example.employeemgmtsystem;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.reactive.HttpHandlerAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



/**
 *
 * @author Vishwajeet.Bharti
 */
@SpringBootApplication(exclude = HttpHandlerAutoConfiguration.class)
@EntityScan("com.example.employeemgmtsystem")
//@EntityScan("com.example.employee.management.system")
//@EnableJpaRepositories("com.example.employee.management.system")

public class EmployeeManagementSystem {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementSystem.class, args);
    }
}