package com.example.employee.services;

import com.example.employee.dao.EmployeeDao;
import com.example.employee.entities.Employee;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private EmployeeDao employeeDao;

    @Transactional
    @Override
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();
//        System.out.println(session+"2");
        return session.createQuery("FROM Employee", Employee.class).list();
    }

    @Transactional
    @Override
    public Employee getEmployeeById(int id) {
        return employeeDao.getEmployeeById(id);
    }


    @Transactional
    @Override
    public void saveEmployee(Employee employee) {
        employeeDao.saveEmployee(employee);
    }

    @Transactional
    @Override
    public void deleteEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class, id);
        if (employee != null) {
            session.delete(employee);
        }

    }
    @Transactional
    @Override
    public boolean isUsernameUnique(String username) {
        return employeeDao.getEmployeeByUsername(username) == null;
    }
}
