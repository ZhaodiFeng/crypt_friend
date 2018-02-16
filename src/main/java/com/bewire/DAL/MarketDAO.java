package com.bewire.DAL;

import com.bewire.Models.Market;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MarketDAO extends CrudRepository<Market,Integer> {
    Market findFirstByName(String name);
    List<Market> findAllByPayCurrencyId(int id);
    List<Market> findAllByBuyCurrencyId(int id);
}
