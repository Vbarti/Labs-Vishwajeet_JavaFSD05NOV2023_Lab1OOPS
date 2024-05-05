package com.example.CollegeFest.service;

import com.example.CollegeFest.entity.User;

public interface UserService {
    User findByUsername(String username);
    boolean authenticate(String username, String password);
}
