// RoleService.java
package com.example.EMS.service;

import com.example.EMS.model.Role;

import java.util.List;

public interface RoleService {
    Role saveRole(Role role);
    List<Role> getAllRoles();
    Role getRoleById(Long id);
    Role updateRole(Role role);
    boolean existsByName(String name);
    boolean existsByNameExcludingId(String name, Long id);
    void deleteRole(Long id);
    
}
