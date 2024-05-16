// UserService.java
package com.example.EMS.service;

import com.example.EMS.model.User;

import java.util.List;

public interface UserService {
	User findByUsername(String username);
	boolean isAdmin(String username);
    User saveUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
    User updateUser(User user);
    void deleteUser(Long id);
//    void addRoleToUser(Long userId, Long roleId);
//    void removeRoleFromUser(Long userId, Long roleId);
    
}
