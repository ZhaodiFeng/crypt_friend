package com.bewire.DAL;

import com.bewire.Models.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface UserDAO extends CrudRepository<User,Long> {
    public User findById();
}
