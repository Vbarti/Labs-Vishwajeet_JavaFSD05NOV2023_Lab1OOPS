/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.example.CollegeFest;
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
@EntityScan("com.example.CollegeFest")

public class CollegeFestApplication {

    public static void main(String[] args) {
        SpringApplication.run(CollegeFestApplication.class, args);
    }
}