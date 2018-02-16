package com.bewire.BLL;

import com.bewire.DAL.CurrencyDAO;
import com.bewire.Models.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CurrencyBLL implements  ICurrencyBLL {
    @Autowired
    CurrencyDAO currencyDAO;

    @Transactional
    public List<Currency> getCurrenciesList(){
        return currencyDAO.getAllByIdIsNotNull();
    }

    @Override
    public Currency getCurrencyByName(String name) {
        return currencyDAO.findCurrencyByName(name);
    }

    @Override
    public List<Currency> filterCurrencyByKey(String key) {
        return currencyDAO.findAllByNameContainingIgnoreCaseOrSymbolContainingIgnoreCase(key,key);
    }

    @Override
    public List<Currency> getTopCurrencies(int nummber) {
        List<Currency> currencies=currencyDAO.getAllByIdIsNotNull();
        if(nummber>currencies.size())
            return currencies;
        else
            return currencies.subList(0,nummber-1);
    }

    @Override
    public Currency getCurrencyById(int id) {
        return currencyDAO.findOne(id);
    }

}
