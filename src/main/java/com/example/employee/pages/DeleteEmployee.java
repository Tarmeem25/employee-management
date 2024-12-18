package com.example.employee.pages;

import com.example.employee.entities.Employee;
import com.example.employee.services.EmployeeService;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

public class DeleteEmployee {
    @Inject
    private EmployeeService employeeService;

    @Property
    private int employeeId;

    public Object onActivate(int id) {
        // Delete the employee record by ID
        this.employeeId = id;
        employeeService.deleteEmployee(id);
        return EmployeeDetails.class; // Redirect to EmployeeDetails page
    }

    public int onPassivate() {
        // Pass the ID back so it can be included in the URL
        return employeeId;
    }
}
