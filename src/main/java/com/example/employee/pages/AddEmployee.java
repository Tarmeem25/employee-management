package com.example.employee.pages;

import com.example.employee.entities.Employee;
import com.example.employee.services.EmployeeService;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

public class AddEmployee {

    @Property
    private String username;

    @Property
    private int age;

    @Property
    private String address;

    @Property
    private String password;

    @Inject
    private EmployeeService employeeService;

    public Object onSuccess(){
        Employee newEmployee = new Employee(username, age, address, password);
        employeeService.saveEmployee(newEmployee);
        return EmployeeDetails.class;
    }


}


