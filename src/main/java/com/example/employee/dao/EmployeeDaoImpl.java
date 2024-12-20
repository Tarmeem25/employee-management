package com.example.employee.dao;

import com.example.employee.entities.Employee;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getAllEmployees() {

        return sessionFactory.getCurrentSession()
                .createQuery("FROM Employee", Employee.class)
                .list();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Employee e WHERE e.id = :id", Employee.class)
                .setParameter("id", id)
                .uniqueResult();

    }

    @Override
    public void saveEmployee(Employee employee) {
        sessionFactory.getCurrentSession().saveOrUpdate(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        Employee employee = getEmployeeById(id);
        if (employee != null) {
            sessionFactory.getCurrentSession().delete(employee);
        }
    }

    @Override
    public Employee getEmployeeByUsername(String username) {

        return (Employee) sessionFactory.getCurrentSession()
                .createQuery("FROM Employee e WHERE e.username = :username")
                .setParameter("username", username)
                .uniqueResult();

    }


}
