package com.example.employee.pages;


import com.example.employee.services.LoginService;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.http.Link;
import org.apache.tapestry5.http.services.Response;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;

import java.io.IOException;


public class Login {
    @Property
    private String username;
    @Property
    private String password;
    @Inject
    private LoginService loginService;

    public Object onSuccess() {
        if (loginService.validateLogin(username, password)) {
            System.out.println("Login successful");
            return EmployeeDetails.class;
        }
        return null;
    }


}

