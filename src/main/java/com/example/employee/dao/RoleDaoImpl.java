package com.example.employee.dao;

import com.example.employee.entities.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RoleDaoImpl implements RoleDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role getRoleById(int roleId) {
        return entityManager.find(Role.class, roleId);
    }
}
