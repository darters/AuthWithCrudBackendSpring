package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("/getAll")
    public List<Employee> allUser() {
        List<Employee> allEmployee = employeeService.getAll();
        return allEmployee;
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String forAdmin() {
        return "This for ADMIN";
    }
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/{employeeId}")
    public Employee getById(@PathVariable("employeeId")int employeeId) {
        Employee employee = employeeService.getEmployee(employeeId);
        return employee;
    }
    @PostMapping("/addEmployee")
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @DeleteMapping("/deleteEmployee/{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId")int employeeId) {
        employeeService.deleteEmployee(employeeId);
    }
}

