package com.example.employee.components;

import org.apache.tapestry5.annotations.Parameter;

public class Header {
    @Parameter(required = true)
    private String title;

    public String getTitle() {
        return title;
    }
}