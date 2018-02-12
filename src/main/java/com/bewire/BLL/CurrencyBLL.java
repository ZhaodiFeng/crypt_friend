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
}
