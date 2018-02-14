package com.bewire.DAL;

import com.bewire.Models.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface TransactionDAO extends CrudRepository<Transaction,Integer> {
}
