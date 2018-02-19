package com.bewire.BLL;

import com.bewire.Models.Market;

import java.util.List;

public interface IMarketBLL {
    List<Market> getAllPayMarketByCurrencyId(int id);
    List<Market> getAllBuyMarketByCurrencyId(int id);
    List<Market> getAllByExchangeIdAndAndBuyCurrencyId(int exchangeId,int currencyId);
    List<Market> getAllByExchangeIdAndAndPayCurrencyId(int exchangeId,int currencyId);
}
