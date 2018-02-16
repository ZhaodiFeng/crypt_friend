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
}
