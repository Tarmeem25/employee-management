    package com.example.employee.pages;

    import com.example.employee.entities.Employee;
    import com.example.employee.entities.Role;
    import com.example.employee.services.EmployeeService;
    import com.example.employee.services.RoleService;
    import org.apache.tapestry5.annotations.InjectComponent;
    import org.apache.tapestry5.annotations.Property;
    import org.apache.tapestry5.corelib.components.Form;
    import org.apache.tapestry5.ioc.annotations.Inject;
    import org.hibernate.type.TrueFalseType;

    public class AddEmployee {

        @Property
        private String username;

        @Property
        private int age;

        @Property
        private String address;

        @Property
        private String password;

        @Property
        private boolean isAdmin;

        @Inject
        private EmployeeService employeeService;

        @Inject
        private RoleService roleService;

        @InjectComponent
        private Form form;

        void onValidateFromForm() {

            if (username == null || username.isEmpty()) {
                form.recordError("Username is required.");
            } else if (!username.matches("^[a-zA-Z][a-zA-Z0-9]*$")) {
                form.recordError("Username must start with a letter and can contain numbers.");
            } else if (username.length() < 3 || username.length() > 20) {
                form.recordError("Username must be between 3 and 20 characters.");
            } else if (!employeeService.isUsernameUnique(username)) {
                form.recordError("Username already exists. Please choose a different one.");
            }

            if (age < 18 || age > 65) {
                form.recordError("Age must be between 18 and 65.");
            }

            if (address == null || address.length() < 5 || address.length() > 50) {
                form.recordError("Address must be between 5 and 50 characters.");
            }

            if (password == null || password.length() < 6) {
                form.recordError("Password must be at least 6 characters.");
            }

        }

         Object onSuccess(){
                int roleId = isAdmin ? 1 : 2;
                Role employeeRole = roleService.findRoleById(roleId);
                Employee newEmployee = new Employee(username, age, address, password, employeeRole);
                employeeService.saveEmployee(newEmployee);
                return EmployeeDetails.class;


        }


    }


