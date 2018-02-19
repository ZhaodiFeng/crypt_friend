package com.bewire.DAL;

import com.bewire.Models.Exchange;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExchangeDAO extends CrudRepository<Exchange,Integer> {
    Exchange findFirstByName(String name);

    List<Exchange> getAllByIdIsNotNull();
}
