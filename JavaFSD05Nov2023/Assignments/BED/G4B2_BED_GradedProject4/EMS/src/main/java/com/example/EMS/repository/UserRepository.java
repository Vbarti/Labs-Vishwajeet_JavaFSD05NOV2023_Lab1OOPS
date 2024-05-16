// UserRepository.java
package com.example.EMS.repository;

import com.example.EMS.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    
    
    @Query("SELECT ur.role.name FROM UserRole ur WHERE ur.user.id = :userId")
    List<String> getUserAuthorities(Long userId);
    
//    @Query("SELECT ur.role.name FROM User u JOIN u.roles ur WHERE u.username = :username")
//    List<String> getUserRolesByUsername(@Param("username") String username);
    
//    @Query("SELECT r.name FROM User u JOIN u.roles ur JOIN ur.role r WHERE u.username = :username")
//    List<String> getUserRolesByUsername(@Param("username") String username);
    
//    @Query("SELECT r.name FROM User u JOIN u.roles r WHERE u.id = :userId")
//    List<String> getUserAuthorities(Long userId);
    
//    @Query("SELECT ur.role.name FROM UserRoles ur WHERE ur.user.id = :userId")
//    List<String> getUserAuthorities(@Param("userId") Long userId);
}
