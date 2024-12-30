    package com.example.employee.pages;


    import com.example.employee.services.LoginService;
    import org.apache.tapestry5.ValidationException;
    import org.apache.tapestry5.annotations.InjectPage;
    import org.apache.tapestry5.annotations.Property;
    import org.apache.tapestry5.ioc.annotations.Inject;


    public class Login {
        @Property
        private String username;

        @Property
        private String password;

        @Inject
        private LoginService loginService;

        @Property
        private String errorMessage;

        @InjectPage
        private EmployeeDetails employeeDetails;

         void onValidateFromForm() throws ValidationException{
            if (!loginService.validateLogin(username, password)) {
                errorMessage = "Invalid username or password";
                throw new ValidationException(errorMessage);
            }
        }

         Object onSuccess(){

             String role = loginService.getUserRole(username);
             int employeeId = loginService.getEmployeeId(username);
             System.out.println(role);
             employeeDetails.setLoggedInUserRole(role);  // Set the role for the EmployeeDetails page
             employeeDetails.setEmpId(employeeId);
             return employeeDetails;
        }
    }

