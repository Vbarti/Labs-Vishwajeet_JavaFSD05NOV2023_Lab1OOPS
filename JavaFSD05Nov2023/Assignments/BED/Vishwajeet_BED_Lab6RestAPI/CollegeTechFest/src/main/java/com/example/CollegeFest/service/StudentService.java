package com.example.CollegeFest.service;
import java.util.List;

import com.example.CollegeFest.entity.Student;

public interface StudentService {

  public List<Student> findAll();
  
  public void save(Student student);
  
  public Student findById(int id);
  
  public void saveOrUpdate(int id, String firstName, String lastName, String course, String country);
  
  public void deleteById(int id);
  
}  
