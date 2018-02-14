package com.bewire.BLL;

import com.bewire.DAL.RoleDAO;
import com.bewire.DAL.UserRoleDAO;
import com.bewire.Models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRoleBLL implements IUserRoleBLL {
    @Autowired
    UserRoleDAO userRoleDAO;
    @Autowired
    RoleDAO roleDAO;


    @Override
    public List<Role> getRolesOfUser(String userId) {
        List<Role> roles=new ArrayList<>();
        userRoleDAO.findAllByUserId(userId).
                forEach(userRole -> roles.add(roleDAO.findRoleById(userRole.getRoleId())));
        return roles;
    }
}
