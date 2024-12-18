package com.example.employee.services;

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

    @Transactional
    @Override
    public boolean validateLogin(String username, String password) {

        Session session = sessionFactory.getCurrentSession();

        Employee employee = (Employee) session.createQuery("FROM Employee WHERE username = :username")
                .setParameter("username", username)
                .uniqueResult();


        return employee != null && employee.getPassword().equals(password);
    }
}
