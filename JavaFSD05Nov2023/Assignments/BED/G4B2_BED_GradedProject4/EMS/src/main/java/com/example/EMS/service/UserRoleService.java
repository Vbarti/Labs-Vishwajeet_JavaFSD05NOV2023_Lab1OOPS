package com.example.EMS.service;

import java.util.List;

import com.example.EMS.model.Role;
import com.example.EMS.model.User;

public interface UserRoleService {

	void addRoleToUser(User user, Role role);
    void removeRoleFromUser(User user, Role role);
    List<Role> getUserRoles(Long userId);
    
}
