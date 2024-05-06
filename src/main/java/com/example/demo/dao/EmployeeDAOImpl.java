package com.example.demo.dao;

import com.example.demo.entity.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    @Autowired
    private EntityManager entityManager;
    public List<Employee> getAll() {
        List<Employee> allUser = entityManager.createQuery("from Employee ", Employee.class).getResultList();
        return allUser;
    }
    @Override
    public Employee getEmployee(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }
    @Override
    public void addEmployee(Employee employee) {
        entityManager.merge(employee);
    }
    @Override
    public void deleteEmployee(int id) {
        entityManager.createQuery("delete from Employee " + "where id =:employeeId").setParameter("employeeId", id).executeUpdate();
    }
}
