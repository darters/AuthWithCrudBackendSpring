package com.example.demo.service;

import com.example.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAll();
    public Employee getEmployee(int id);
    public void addEmployee(Employee employee);
    public void deleteEmployee(int id);
}
