package com.example.CollegeFest.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.CollegeFest.service.RoleService;
import com.example.CollegeFest.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }
//    
//    @PostMapping("/login")
//    public String login(HttpServletRequest request, @RequestParam String username, @RequestParam String password) {
//        // Implement your authentication logic here
//        if (userService.authenticate(username, password)) {
//            return "redirect:/students/list"; // Redirect to student list page after successful login
//        } else {
//            request.setAttribute("error", "Invalid username or password");
//            return "login"; // Return to login page with error message
//        }
//    }

    // Other user-related controller methods as needed
}
