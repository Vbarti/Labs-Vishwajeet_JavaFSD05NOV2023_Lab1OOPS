// UserServiceImpl.java
package com.example.EMS.service;

import com.example.EMS.model.Role;
import com.example.EMS.model.User;
import com.example.EMS.repository.RoleRepository;
import com.example.EMS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
    
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    
    @Override
    public boolean isAdmin(String username) {
        // Retrieve the user by username from the database
        User user = userRepository.findByUsername(username);
        if (user == null) {
            // User not found
            return false;
        }

        // Check if the user has the admin role
        return user.getRoles().stream().anyMatch(role -> role.getName().equals("ADMIN"));
    }
    
    
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);
    }

    @Override
    public User updateUser(User user) {
    	return userRepository.save(user);
    } 

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }    
    
    
//    public List<Role> getUserRoles(Long userId) {
//        User user = userRepository.findById(userId).orElse(null);
//        if (user != null) {
//            return user.getRoles();
//        }
//        return null;
//    }
    
    
    
    
}
