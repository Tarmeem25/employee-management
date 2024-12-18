package com.example.employee.dao;

import com.example.employee.entities.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getAllEmployees() {

        return sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return (Employee) sessionFactory.getCurrentSession()
                .createCriteria(Employee.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();

    }

    @Override
    public void saveEmployee(Employee employee) {
        sessionFactory.getCurrentSession().saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployeeByUsername(String username) {
      return (Employee) sessionFactory.getCurrentSession()
                .createCriteria(Employee.class)
                .add(Restrictions.eq("username", username))
                .uniqueResult(); // Returns null if no employee is found


    }


}
