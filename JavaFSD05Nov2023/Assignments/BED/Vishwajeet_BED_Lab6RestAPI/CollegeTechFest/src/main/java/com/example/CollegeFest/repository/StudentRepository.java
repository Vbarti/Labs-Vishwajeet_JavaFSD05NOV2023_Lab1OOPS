package com.example.CollegeFest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CollegeFest.entity.Student;

public interface StudentRepository 
  extends JpaRepository<Student, Integer> {

} 