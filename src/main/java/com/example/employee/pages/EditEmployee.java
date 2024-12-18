package com.example.employee.pages;

import com.example.employee.entities.Employee;
import com.example.employee.services.EmployeeService;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.annotations.Inject;


public class EditEmployee {
    @Property
    private Employee employee;

    @Inject
    private EmployeeService employeeService;

    @Property
    private int employeeId;

    @InjectComponent
    private Form form;

    void onActivate(int id) {
        // Fetch employee data based on the given ID
        this.employeeId = id;
        this.employee = employeeService.getEmployeeById(id);
    }

    void setupRender() {
        // Ensure employee data is available before rendering
        if (employee == null) {
            employee = employeeService.getEmployeeById(employeeId);
        }
    }

    void onValidateFromForm() {
        if (employee.getUsername() == null || employee.getUsername().isEmpty()) {
            form.recordError("Username is required.");
        } else if (!employee.getUsername().matches("^[a-zA-Z][a-zA-Z0-9]*$")) {
            form.recordError("Username must start with a letter and can contain numbers.");
        } else if (employee.getUsername().length() < 3 || employee.getUsername().length() > 20) {
            form.recordError("Username must be between 3 and 20 characters.");
        }

        if (employee.getAge() < 18 || employee.getAge() > 65) {
            form.recordError("Age must be between 18 and 65.");
        }

        if (employee.getAddress() == null || employee.getAddress().length() < 5 || employee.getAddress().length() > 50) {
            form.recordError("Address must be between 5 and 50 characters.");
        }

        if (employee.getPassword() == null || employee.getPassword().length() < 6) {
            form.recordError("Password must be at least 6 characters.");
        }
    }

    public Object onSuccess() {
        // Save updated employee details
        employeeService.saveEmployee(employee);
        return EmployeeDetails.class; // Redirect to EmployeeDetails page
    }

    public int onPassivate() {
        return employeeId; // Pass ID back for URL preservation
    }
}
