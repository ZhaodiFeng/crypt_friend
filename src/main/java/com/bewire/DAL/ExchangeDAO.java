package com.bewire.DAL;

import com.bewire.Models.Exchange;
import org.springframework.data.repository.CrudRepository;

public interface ExchangeDAO extends CrudRepository<Exchange,Integer> {
    Exchange findFirstByName(String name);
}
