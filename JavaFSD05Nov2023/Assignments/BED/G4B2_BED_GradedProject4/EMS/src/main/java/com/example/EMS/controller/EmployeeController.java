package com.example.EMS.controller;

import com.example.EMS.model.Employee;
import com.example.EMS.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public String getAllEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employeesList"; // View name
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String getEmployeeById(@PathVariable Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "employeeDetails"; // View name
    }

    @GetMapping("/addEmployeeForm")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String createEmployeeForm() {
        return "addEmployeeForm"; // View name
    }

    @PostMapping("/createEmployee")
    public String createEmployee(@ModelAttribute Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employees/list"; // Redirect to employee list
    }

    @GetMapping("/editEmployeeForm")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String editEmployeeForm(@RequestParam Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "editEmployeeForm"; // View name
    }

    @PostMapping("/updateEmployee")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String updateEmployee(@ModelAttribute Employee employee) {
        employeeService.updateEmployee(employee);
        return "redirect:/employees/list"; // Redirect to employee list
    }

    @GetMapping("/viewEmployee")
    public String viewEmployee(@RequestParam("id") Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "viewEmployee";
    }
    @GetMapping("/deleteEmployee")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteEmployee(@RequestParam Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees/list"; // Redirect to employee list
    }
    
    @RequestMapping(value = "/error/403")
	public ModelAndView handleAccessDeniedError(Principal user) {

	  ModelAndView model = new ModelAndView();

	  if (user != null) {
	    model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");
	  } else {
	    model.addObject("msg", "You do not have permission to access this page!");
	  }

	  model.setViewName("authorization-error-403");
	  return model;
	}  
}
