package com.example.CollegeFest.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CollegeFest.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByUsername(String username);
}
