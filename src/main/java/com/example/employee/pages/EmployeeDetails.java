package com.example.employee.pages;

import com.example.employee.components.Header;
import com.example.employee.entities.Employee;
import com.example.employee.services.EmployeeService;
import org.apache.tapestry5.annotations.InjectComponent;
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

    void setupRender() {
        employees = employeeService.getAllEmployees();
    }

}
