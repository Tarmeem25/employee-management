package com.example.employee.services;

import com.example.employee.dao.EmployeeDao;
import com.example.employee.entities.Employee;
import org.springframework.stereotype.Service;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private EmployeeDao employeeDao;

    @Transactional
    @Override
    public boolean validateLogin(String username, String password) {

        Session session = sessionFactory.getCurrentSession();

        Employee employee = (Employee) session.createQuery("FROM Employee e WHERE e.username = :username")
                .setParameter("username", username)
                .uniqueResult();


        return employee != null && employee.getPassword().equals(password);
    }

    @Transactional
    @Override
    public String getUserRole(String username) {
        Employee employee = employeeDao.getEmployeeByUsername(username);  // Find the employee by username

        if (employee != null) {
            return employee.getRole().getRole_name();  // Assuming you have a 'role' field in Employee entity
        }

        return "EMPLOYEE";  // Default role if the user is not found
    }

    @Transactional
    @Override
    public int getEmployeeId(String username) {
        Employee employee = employeeDao.getEmployeeByUsername(username);
        if (employee != null) {
            return employee.getId();
        }
        return 0;
    }
}
