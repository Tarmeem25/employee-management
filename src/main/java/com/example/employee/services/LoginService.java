package com.example.employee.services;

public interface LoginService {
    boolean validateLogin(String username, String password);
    String getUserRole(String username);

    int getEmployeeId(String username);
}
