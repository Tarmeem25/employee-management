package com.example.employee.pages;

import org.apache.tapestry5.annotations.Property;

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


