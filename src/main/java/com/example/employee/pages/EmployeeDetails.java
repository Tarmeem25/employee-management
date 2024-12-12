package com.example.employee.pages;

import com.example.employee.entities.Employee;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

public class EmployeeDetails {
    @Property
    private Employee employee;


    void onActivate(int id) {
        if (id == 1) {
            employee = new Employee(1, "John Doe", 30, "1234 Elm St");
        } else if (id == 2) {
            employee = new Employee(2, "Jane Smith", 25, "5678 Oak St");
        }
    }
}
