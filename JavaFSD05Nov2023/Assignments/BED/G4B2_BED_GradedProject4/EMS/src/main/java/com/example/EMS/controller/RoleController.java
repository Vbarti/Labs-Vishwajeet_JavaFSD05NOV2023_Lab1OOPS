package com.example.EMS.controller;

import com.example.EMS.model.Role;
import com.example.EMS.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/{userId}/list")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String getAllRoles(@PathVariable Long userId,Model model) {
        List<Role> roles = roleService.getAllRoles();
        model.addAttribute("roles", roles);
        model.addAttribute("userId", userId);
        return "roleList"; // View name
    }

    @GetMapping("/{userId}/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String getRoleById(@PathVariable Long id,@PathVariable Long userId, Model model) {
        Role role = roleService.getRoleById(id);
        model.addAttribute("role", role);
        model.addAttribute("userId", userId);
        return "roleDetails"; // View name
    }

    @GetMapping("/{userId}/addRoleForm")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String createRoleForm(@PathVariable Long userId,@RequestParam(required = false) String error, Model model) {
    	model.addAttribute("userId", userId);
    	if (error != null) {
            model.addAttribute("error", error);
        }
        return "addRoleForm"; // View name
    }

    
    @PostMapping("/{userId}/create")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String createRole(@PathVariable Long userId,@ModelAttribute Role role,RedirectAttributes redirectAttributes) {
        if (role.getName() == null || role.getName().trim().isEmpty()) {
            // Handle error: Role name is required
        	redirectAttributes.addFlashAttribute("error", "RoleNameRequired");
            return "redirect:/roles/" + userId + "/addRoleForm";
            //return "redirect:/roles/"+userId+"/addRoleForm?error=RoleNameRequired";
        }

        // Check if role name is unique
        if (roleService.existsByName(role.getName())) {
            // Handle error: Role name already exists
        	redirectAttributes.addFlashAttribute("error", "RoleNameExists");
            return "redirect:/roles/" + userId + "/addRoleForm";
        	//return "redirect:/roles/"+userId+"/addRoleForm?error=RoleNameExists";
        }        
        roleService.saveRole(role);
        return "redirect:/userRoles/addRole/" + userId;
    }
//    @PostMapping("/{userId}/create")
//    public String createRole(@PathVariable Long userId,@ModelAttribute Role role) {
//        roleService.saveRole(role);
//        return "redirect:/roles/"+userId+"/list"; // Redirect to role list
//    }    
    

    @GetMapping("/{userId}/editRoleForm")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String editRoleForm(@PathVariable Long userId,@RequestParam Long id,@RequestParam(required = false) String error, Model model) {
        Role role = roleService.getRoleById(id);
        model.addAttribute("userId", userId);
        model.addAttribute("role", role);
        if (error != null) {
            model.addAttribute("error", error);
        }
        return "editRoleForm"; // View name
    }

    @PostMapping("/{userId}/update")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String updateRole(@PathVariable Long userId, @ModelAttribute Role role,RedirectAttributes redirectAttributes) {
        if (role.getName() == null || role.getName().trim().isEmpty()) {
            // Handle error: Role name is required
        	redirectAttributes.addFlashAttribute("error", "RoleNameRequired");
            return "redirect:/roles/" + userId + "/editRoleForm?id="+role.getId();
        	//return "redirect:/roles/${userId}/editRoleForm?error=RoleNameRequired";
        }

        // Check if role name is unique
        if (roleService.existsByNameExcludingId(role.getName(), role.getId())) {
            // Handle error: Role name already exists
        	redirectAttributes.addFlashAttribute("error", "RoleNameExists");
            return "redirect:/roles/" + userId + "/editRoleForm?id="+role.getId();
        	//return "redirect:/roles/${userId}/editRoleForm?error=RoleNameExists";
        }

        roleService.updateRole(role);
        return "redirect:/roles/" + userId + "/list"; // Redirect to role list
    }

    
//    @PostMapping("/{userId}/update")
//    public String updateRole(@PathVariable Long userId,@ModelAttribute Role role) {
//        roleService.updateRole(role);
//        return "redirect:/roles/"+userId+"/list"; // Redirect to role list
//    }

    @GetMapping("/{userId}/delete")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteRole(@PathVariable Long userId,@RequestParam Long id) {
        roleService.deleteRole(id);
        return "redirect:/roles/"+userId+"/list"; // Redirect to role list
    }
}
