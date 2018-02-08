package com.bewire.DAL;

import com.bewire.Models.Currency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CurrencyDAO extends CrudRepository<Currency,Long> {
    public Currency findCurrencyById(int id);
}
