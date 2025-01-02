package com.example.employee.dao;

import com.example.employee.entities.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    @Autowired
    private SessionFactory sessionFactory;

    @PersistenceContext
    private EntityManager entityManager;


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

        if (employee.getUsername() != null && employee.getSearchVector() == null)  {
            String name = employee.getUsername();
            String searchVector = "to_tsvector('english', :name)";

            employee.setSearchVector(searchVector);
        }
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

    @Override
    public List<Employee> searchEmployee(String query){
        String sql = "SELECT * FROM public.employee WHERE search_vector @@ to_tsquery('english', :query)";
        Query q = entityManager.createNativeQuery(sql, Employee.class);
        q.setParameter("query", query.replace(" ", " & "));
        List<Employee> results = q.getResultList();
        return results;
    }

    @Override
    public List<String> getEmployeeSuggestions(String query) {
        return (List<String>) sessionFactory.getCurrentSession()
                .createSQLQuery("SELECT username FROM public.employee WHERE username LIKE :query")
                .addScalar("username", StandardBasicTypes.STRING)
                .setParameter("query", "%" + query + "%")
                .setMaxResults(10)
                .getResultList();
    }


}
