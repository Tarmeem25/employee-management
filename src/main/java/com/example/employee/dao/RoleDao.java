package com.example.employee.dao;

import com.example.employee.entities.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


public interface RoleDao {
    Role getRoleById(int id);
}
