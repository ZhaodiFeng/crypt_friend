package com.bewire.DAL;

import com.bewire.Models.UserRole;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRoleDAO extends CrudRepository<UserRole,Integer> {
    List<UserRole> findAllByUserId(String userId);
}
