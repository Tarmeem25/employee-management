package com.example.employee.services;


import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.commons.MappedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;


public class MyEmpModule
{
    public static void bind(ServiceBinder binder) {
        // Bind LoginService to LoginServiceImpl
        binder.bind(LoginService.class, LoginServiceImpl.class);

        // Bind EmployeeService to EmployeeServiceImpl
        binder.bind(EmployeeService.class, EmployeeServiceImpl.class);
    }

    public static void contributeApplicationDefaults(MappedConfiguration<String,String> configuration)
    {
        configuration.add(SymbolConstants.SUPPORTED_LOCALES, "en,fr,de");
        configuration.add(SymbolConstants.FILE_CHECK_INTERVAL, "10 m");

    }

}
