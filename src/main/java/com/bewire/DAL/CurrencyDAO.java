package com.bewire.DAL;

import com.bewire.Models.Currency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface CurrencyDAO extends CrudRepository<Currency,Integer> {
    public List<Currency> getAllByIdIsNotNull();
    public Currency findCurrencyById(int id);
    public Currency findCurrencyByName(String name);
    public List<Currency> findAllByNameContainingIgnoreCaseOrSymbolContainingIgnoreCase(String key1,String key2);
}
