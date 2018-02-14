package com.bewire.BLL;

import com.bewire.Models.Currency;

import java.util.List;

public interface ICurrencyBLL {
    List<Currency> getCurrenciesList();
    Currency getCurrencyByName(String name);
    List<Currency> filterCurrencyByKey(String key);
    List<Currency> getTopCurrencies(int number);
}
