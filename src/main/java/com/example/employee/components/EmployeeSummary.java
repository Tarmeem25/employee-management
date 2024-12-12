package com.example.employee.components;

import com.example.employee.entities.Employee;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;

public class EmployeeSummary {
    @Parameter(required = true)
    @Property
    private Employee employee;

}