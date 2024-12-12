package com.example.employee.pages;

import com.example.employee.entities.Employee;
import org.apache.tapestry5.ValidationException;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

public class AddEmployee {

    @Property
    private String name;

    @Property
    private int age;

    @Property
    private String address;


    void onSubmit() {
        // Dummy employee addition logic
        System.out.println("Employee Added: " + name + ", " + age + ", " + address);
    }
    }


