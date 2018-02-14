package com.bewire.DAL;

import com.bewire.Models.TransactionType;
import org.springframework.data.repository.CrudRepository;

public interface TransactionTypeDAO extends CrudRepository<TransactionType,Integer> {
    int findFirstByName(String name);
}
