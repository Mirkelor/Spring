package com.mirkelor.dao;

import com.mirkelor.entity.Role;

public interface RoleDao {

    public Role findRoleByName(String theRoleName);
}
