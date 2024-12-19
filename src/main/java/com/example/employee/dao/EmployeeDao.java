package com.example.employee.dao;

import com.example.employee.entities.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    void saveEmployee(Employee employee);
    void deleteEmployee(int id);
    Employee getEmployeeByUsername(String username);

}
