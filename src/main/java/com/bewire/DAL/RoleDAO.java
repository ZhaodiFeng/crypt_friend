package com.bewire.DAL;

import com.bewire.Models.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleDAO extends CrudRepository<Role,Integer> {
    Role findRoleByName(String name);
    Role findRoleById(int id);
}
