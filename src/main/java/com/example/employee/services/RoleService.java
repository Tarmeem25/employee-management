package com.example.employee.services;

import com.example.employee.dao.RoleDao;
import com.example.employee.entities.Role;
import org.apache.tapestry5.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;


public interface RoleService {

    Role findRoleById(int id);
}
