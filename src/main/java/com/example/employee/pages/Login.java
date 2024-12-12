package com.example.employee.pages;


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
    @InjectPage
    private EmployeeList employeeList;

    @Inject
    private Response response;

    @Inject
    private PageRenderLinkSource pageRenderLinkSource;


    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password123";

    public void onSubmit() throws IOException {
        if (VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password)) {
            Link link = pageRenderLinkSource.createPageRenderLink(EmployeeList.class);
            // Redirect to EmployeeList page
            response.sendRedirect(link.toAbsoluteURI());
        } else {
            // Handle invalid login
        }
    }
}

