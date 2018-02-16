package com.bewire.BLL;

import com.bewire.Models.Market;

import java.util.List;

public interface IMarketBLL {
    List<Market> getAllPayMarketByCurrencyId(int id);
    List<Market> getAllBuyMarketByCurrencyId(int id);
}
