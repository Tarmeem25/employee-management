package com.example.employee.services;

import com.example.employee.dao.RoleDao;
import com.example.employee.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleDao roleDao;

    @Transactional
    @Override
    public Role findRoleById(int roleId) {
        return roleDao.getRoleById(roleId);

    }
}
