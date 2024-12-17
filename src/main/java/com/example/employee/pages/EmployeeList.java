package com.example.employee.pages;

import com.example.employee.entities.Employee;
import com.example.employee.services.EmployeeService;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeList {
    @Property
    private Employee employee;

    @Inject
    private EmployeeService employeeService;

    @Property
    private int employeeId;

   void onActivate(int id) {
       this.employeeId = id;
       employee = employeeService.getEmployeeById(id);
   }

    public int onPassivate() {
        // Pass the ID back so it can be included in the URL
        return employeeId;
    }
}


