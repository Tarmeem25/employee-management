package com.example.employee.pages;

import com.example.employee.entities.Employee;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeList {
    @Property
    private Employee employee;

    @Property
    private List<Employee> employees;

    void setupRender() {
        employees = Arrays.asList(
                new Employee(1, "John Doe", 30, "1234 Elm St"),
                new Employee(2, "Jane Smith", 25, "5678 Oak St")
        );
    }
}


