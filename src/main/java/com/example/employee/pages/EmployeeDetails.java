package com.example.employee.pages;

import com.example.employee.entities.Employee;
import com.example.employee.services.EmployeeService;
import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import java.text.SimpleDateFormat;
import java.util.List;


public class EmployeeDetails {
    @Property
    private List<Employee> employees;

    @Property
    private Employee employee;

    @Inject
    private EmployeeService employeeService;

    @Persist
    @Property
    private String loggedInEmployeeRole;

    @Property
    private boolean isAdmin;

    @Property
    @Persist
    private int employeeId;

    @Property
    @Persist(PersistenceConstants.FLASH)
    private String feedbackMessage;


    void setupRender() {

        employee = employeeService.getEmployeeById(employeeId);
        isAdmin = "ADMIN".equalsIgnoreCase(loggedInEmployeeRole);

        if (isAdmin) {
            employees = employeeService.getAllEmployees();
        } else {
            employees = List.of(employee);
        }

    }

    public String getFormattedDob() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
        return sdf.format(employee.getDob());
    }

    void setEmpId(int employeeId) {
        this.employeeId = employeeId;
    }

    void setLoggedInUserRole(String role) {
        this.loggedInEmployeeRole = role;
    }


    void onPromote(int employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        System.out.println(employee.getUsername());

        if (employee.getRole().getRole_name().equalsIgnoreCase("ADMIN")) {
            feedbackMessage="Admin can't be promoted!";
        }

        if (employee.getRole().getRole_name().equalsIgnoreCase("MANAGER")) {
            feedbackMessage="Already a Manager";
        }

        if(employee.getRole().getRole_name().equalsIgnoreCase("EMPLOYEE")){
            employee.getRole().setRole_id(3);
            feedbackMessage="Promoted";
            employeeService.saveEmployee(employee);

        }
        }

}


