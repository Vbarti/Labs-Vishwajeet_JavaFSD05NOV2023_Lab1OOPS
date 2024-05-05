package com.example.CollegeFest.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "students")
@Getter
@Setter
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "course")
  private String course;

  @Column(name = "country")
  private String country;

  public Student() {

  }

  public Student(String firstName, String lastName, String course, String country) {

    this.firstName = firstName;
    this.lastName = lastName;
    this.course = course;
    this.country = country;
  }
  public Student(int id,String firstName, String lastName, String course, String country) {
        this.id=id;
	    this.firstName = firstName;
	    this.lastName = lastName;
	    this.course = course;
	    this.country = country;
	  }
//
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name = "students")
//public class Student {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "first_name", nullable = false)
//    private String firstName;
//
//    @Column(name = "last_name", nullable = false)
//    private String lastName;
//
//    @Column(name = "course", nullable = false)
//    private String course;
//
//    @Column(name = "country", nullable = false)
//    private String country;
//
//    // Getters and setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getCourse() {
//        return course;
//    }
//
//    public void setCourse(String course) {
//        this.course = course;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }
//    
//    public Student() {
//
//    }
//
//    public Student(String firstName, String lastName, String course, String country) {
//
//      this.firstName = firstName;
//      this.lastName = lastName;
//      this.course = course;
//      this.country = country;
//    }
}
