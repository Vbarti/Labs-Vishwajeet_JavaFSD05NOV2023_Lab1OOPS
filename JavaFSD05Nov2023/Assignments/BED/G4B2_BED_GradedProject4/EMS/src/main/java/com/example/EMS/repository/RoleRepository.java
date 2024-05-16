// RoleRepository.java
package com.example.EMS.repository;

import com.example.EMS.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
	boolean existsByName(String name);
	boolean existsByNameAndIdNot(String name, Long id);
}
