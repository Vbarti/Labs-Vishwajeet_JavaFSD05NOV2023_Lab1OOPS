package com.example.tickettracker.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ticket {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String title;

private String short_description;

private String content;

private Date created_on;

// Getter and setter for ID
public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

// Getters and setters for other fields
public String getTitle() {
    return title;
}

public void setTitle(String title) {
    this.title = title;
}

public String getDescription() {
    return short_description;
}

public void setDescription(String short_description) {
    this.short_description = short_description;
}
public String getContent() {
    return content;
}

public void setContent(String content) {
    this.content = content;
}

public Date getCreatedOn() {
    return created_on;
}

public void setCreatedOn(Date created_on) {
    this.created_on = created_on;
}

}

