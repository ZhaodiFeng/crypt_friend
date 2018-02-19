package com.bewire.BLL;

import com.bewire.DAL.MarketDAO;
import com.bewire.Models.Market;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketBLL implements IMarketBLL {
    @Autowired
    MarketDAO marketDAO;

    @Override
    public List<Market> getAllPayMarketByCurrencyId(int id) {
        return marketDAO.findAllByPayCurrencyId(id);
    }

    @Override
    public List<Market> getAllBuyMarketByCurrencyId(int id) {
        return marketDAO.findAllByBuyCurrencyId(id);
    }

    @Override
    public List<Market> getAllByExchangeIdAndAndBuyCurrencyId(int exchangeId, int currencyId) {
        return marketDAO.getAllByExchangeIdAndAndBuyCurrencyId(exchangeId, currencyId);
    }

    @Override
    public List<Market> getAllByExchangeIdAndAndPayCurrencyId(int exchangeId, int currencyId) {
        return marketDAO.getAllByExchangeIdAndAndPayCurrencyId(exchangeId,currencyId);
    }
}
