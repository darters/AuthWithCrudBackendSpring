package com.example.demo.service;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeDAO employeeRepository;
    @Transactional
    @Override
    public List<Employee> getAll() {
        return employeeRepository.getAll();
    }
    @Transactional
    @Override
    public Employee getEmployee(int id) {
        return employeeRepository.getEmployee(id);
    }

    @Transactional
    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.addEmployee(employee);
    }

    @Transactional
    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteEmployee(id);
    }
}
