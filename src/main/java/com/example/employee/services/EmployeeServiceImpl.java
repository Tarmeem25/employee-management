package com.example.employee.services;

import com.example.employee.dao.EmployeeDao;
import com.example.employee.entities.Employee;
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
        employeeDao.deleteEmployee(id);

    }
    @Transactional
    @Override
    public boolean isUsernameUnique(String username) {
        return employeeDao.getEmployeeByUsername(username) == null;
    }

    @Transactional
    @Override
    public List<Employee> searchEmployee(String query){
        return employeeDao.searchEmployee(query);
    }

    @Transactional
    @Override
    public List<String> getEmployeeSuggestions(String query) {
        return employeeDao.getEmployeeSuggestions(query);
    }

}
