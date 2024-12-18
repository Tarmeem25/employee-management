package com.example.employee.components;

import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;

public class Header {
    @Property
    @Parameter
    private String companyName;

    @Property
    @Parameter
    private String companyAddress;
}
