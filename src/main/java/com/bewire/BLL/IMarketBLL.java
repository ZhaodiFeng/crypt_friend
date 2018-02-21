package com.bewire.BLL;

import com.bewire.Models.Market;
import com.bewire.PL.DTO.MarketDTO;

import java.util.List;

public interface IMarketBLL {
    List<Market> getAllPayMarketByCurrencyId(int id);
    List<Market> getAllBuyMarketByCurrencyId(int id);
    List<MarketDTO> getAllByExchangeIdAndAndBuyCurrencyId(int exchangeId, int currencyId);
    List<MarketDTO> getAllByExchangeIdAndAndPayCurrencyId(int exchangeId, int currencyId);
}
