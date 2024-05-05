package com.example.CollegeFest.serviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CollegeFest.entity.Role;
import com.example.CollegeFest.repository.RoleRepository;
import com.example.CollegeFest.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findRoleByUsername(String username) {
        return roleRepository.findByUsername(username);
    }
}
