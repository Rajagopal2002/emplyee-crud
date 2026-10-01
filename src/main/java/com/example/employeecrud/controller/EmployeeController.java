package com.example.employeecrud.controller;

import com.example.employeecrud.model.Employee;
import com.example.employeecrud.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.employeecrud.model.User;
import com.example.employeecrud.repository.UserRepository;
import org.springframework.security.core.Authentication;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    private final UserRepository userRepository;

    @Autowired
    public EmployeeController(EmployeeService employeeService,
                              UserRepository userRepository) {
        this.employeeService = employeeService;
        this.userRepository = userRepository;
    }

    // Show list of all employees
    @GetMapping
    public String listEmployees(Model model, Authentication authentication) {

        String username = authentication.getName();

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        model.addAttribute("employees",
                employeeService.getAllEmployees(user.getId()));

        return "employee-list";
    }

    // Show form to add a new employee
    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("formTitle", "Add New Employee");
        return "employee-form";
    }

    // Show form to edit an existing employee
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        model.addAttribute("formTitle", "Edit Employee");
        return "employee-form";
    }

    // Save (insert or update) employee
    @PostMapping("/save")
    public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee,
                               BindingResult result,
                               Model model,
                               Authentication authentication) {
        if (result.hasErrors()) {
            model.addAttribute("formTitle", employee.getId() == null ? "Add New Employee" : "Edit Employee");
            return "employee-form";
        }
        String username = authentication.getName();

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        employee.setUser(user);
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    // Delete employee
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }
}
