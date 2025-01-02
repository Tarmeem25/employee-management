package com.example.employee.services;

import com.example.employee.entities.Employee;


import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);

    void saveEmployee(Employee employee);

    void deleteEmployee(int id);

    boolean isUsernameUnique(String username);

    List<Employee> searchEmployee(String query);


    List<String> getEmployeeSuggestions(String query);
}
