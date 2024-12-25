package com.example.employee.pages;

import com.example.employee.entities.Employee;
import com.example.employee.services.EmployeeService;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.ioc.annotations.Inject;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;


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
        this.employeeId = id;
        this.employee = employeeService.getEmployeeById(id);
    }

    void setupRender() {

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
        if (employee.getGender() == null || employee.getGender().isEmpty() || (!employee.getGender().equalsIgnoreCase("Male") && !employee.getGender().equalsIgnoreCase("Female"))) {
            form.recordError("Please select a valid gender.");
        }

        if (employee.getDob() != null) {

            LocalDate birthDate = employee.getDob().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int calculatedAge = Period.between(birthDate, LocalDate.now()).getYears();


            if (calculatedAge != employee.getAge()) {
                form.recordError("The age provided does not match the date of birth.");
            }
            if (birthDate.isEqual(LocalDate.now())) {
                form.recordError("Date of birth cannot be today's date.");
            }
            LocalDate maxDob = LocalDate.now().minus(18, ChronoUnit.YEARS); // 18 years ago
            LocalDate minDob = LocalDate.now().minus(65, ChronoUnit.YEARS); // 65 years ago

            if (birthDate.isAfter(maxDob) || birthDate.isBefore(minDob)) {
                form.recordError("Date of birth must be between 18 and 65 years ago.");
            }
        }
    }

    public Object onSuccess() {

        employeeService.saveEmployee(employee);
        return EmployeeDetails.class;
    }

    public int onPassivate() {
        return employeeId;
    }
}
