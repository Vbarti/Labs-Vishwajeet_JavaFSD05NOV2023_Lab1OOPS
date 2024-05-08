package com.example.CollegeFest.serviceimpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CollegeFest.entity.Student;
import com.example.CollegeFest.repository.StudentRepository;
import com.example.CollegeFest.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

  @Autowired
  StudentRepository studentRepository;

  @Override
  public List<Student> findAll() {

    List<Student> students = studentRepository.findAll();
    return students;
  }

  @Override
  public void save(Student student) {
      studentRepository.save(student);                    
  }
  
  @Override
  public Student findById(int studentId) {
      return studentRepository.findById(studentId).get();
  }  
  
  @Override
  public void saveOrUpdate(int id, String firstName, String lastName, String course, String country) {
      Student student = null;
      if (id == 0) {
          student = new Student(firstName, lastName, course, country);
      } else {
          student = findById(id);
          student.setFirstName(firstName);
          student.setLastName(lastName);
          student.setCourse(course);
          student.setCountry(country);
      }
      studentRepository.save(student);
  }
  
//  @Override
//  public void saveOrUpdate(int id, String firstName, String lastName, String course, String country) {
//
//    System.out.println("Student ID ->" + id);
//
//    Student studentObj = null;
//    if (id == 0) {
//
//      studentObj = new Student(firstName, lastName, course, country);
//      System.out.println("Add Student Scenario");
//    } else {
//
//      System.out.println("Update Student Scenario");
//       studentObj = new Student(id,firstName, lastName, course, country);
////      studentObj = this.findById(id);
////      studentObj.setFirstName(firstName);
////      studentObj.setLastName(lastName);
////      studentObj.setCourse(course);
////      studentObj.setCountry(country);
//    }
//
//    // Save/Update the student
//    this.save(studentObj);
//  }          
  
  
  @Override
  public void deleteById(int id) {
      studentRepository.deleteById(id);    
  }  
}
