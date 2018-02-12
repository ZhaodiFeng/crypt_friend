package com.bewire.DAL;

import com.bewire.Models.Currency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CurrencyDAO extends CrudRepository<Currency,Long> {
    public List<Currency> getAllByIdIsNotNull();
    public Currency findCurrencyById(int id);
    public Currency findCurrencyByName(String name);
}
