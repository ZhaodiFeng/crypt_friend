package com.bewire.BLL;

import com.bewire.Models.Role;

import java.util.List;

public interface IUserRoleBLL {
    List<Role> getRolesOfUser(String userId);
}
