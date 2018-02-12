package com.bewire.DAL;

import com.bewire.Models.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface UserDAO extends CrudRepository<User,Long> {
    public boolean existsById(String id);
    public User findFirstById(String id);
}
