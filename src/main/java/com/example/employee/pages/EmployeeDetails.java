package com.example.employee.pages;

import com.example.employee.entities.Employee;
import com.example.employee.services.EmployeeService;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;


import java.util.List;


public class EmployeeDetails {
    @Property
    private List<Employee> employees;

    @Property
    private Employee employee;

    @Inject
    private EmployeeService employeeService;

    @Persist
    @Property
    private String loggedInEmployeeRole;

    @Property
    private boolean isAdmin;

    @Property
    @Persist
    private int employeeId;

    void setupRender() {
        employee = employeeService.getEmployeeById(employeeId);
        isAdmin = "ADMIN".equalsIgnoreCase(loggedInEmployeeRole);

        if(isAdmin){
            employees = employeeService.getAllEmployees();
        }
        else{
            employees = List.of(employee);
        }
    }

    void setEmpId(int employeeId) {
        this.employeeId = employeeId;
    }

    void setLoggedInUserRole(String role) {
        this.loggedInEmployeeRole = role;
    }
}
