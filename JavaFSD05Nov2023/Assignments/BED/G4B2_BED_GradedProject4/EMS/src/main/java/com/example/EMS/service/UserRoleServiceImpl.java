package com.example.EMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EMS.model.Role;
import com.example.EMS.model.User;
import com.example.EMS.model.UserRole;
import com.example.EMS.repository.UserRoleRepository;

import jakarta.transaction.Transactional;

@Service
public class UserRoleServiceImpl implements UserRoleService {

	
	@Autowired
    private UserRoleRepository userRoleRepository;

	@Override
	public void addRoleToUser(User user, Role role) {
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        userRoleRepository.save(userRole);
    }

	@Transactional
	@Override
    public void removeRoleFromUser(User user, Role role) {
        userRoleRepository.deleteByUserAndRole(user, role);
    }
    
	@Override
    public List<Role> getUserRoles(Long userId) {
        return userRoleRepository.findRolesByUserId(userId);
    }
}
