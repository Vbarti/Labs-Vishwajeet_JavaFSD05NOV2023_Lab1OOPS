package com.example.EMS.repository;

import com.example.EMS.model.Role;
import com.example.EMS.model.User;
import com.example.EMS.model.UserRole;
import com.example.EMS.model.UserRoleId;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface UserRoleRepository extends JpaRepository<UserRole, UserRoleId> {
    void deleteByUserAndRole(User user, Role role);
    
    @Query("SELECT ur.role FROM UserRole ur WHERE ur.user.id = :userId")
    List<Role> findRolesByUserId(Long userId);
}
