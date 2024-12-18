package com.example.employee.services;


import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.commons.MappedConfiguration;


public class MyEmpModule
{

    public static void contributeApplicationDefaults(MappedConfiguration<String,String> configuration)
    {
        configuration.add(SymbolConstants.SUPPORTED_LOCALES, "en,fr,de");
        configuration.add(SymbolConstants.FILE_CHECK_INTERVAL, "10 m");
    }
}
