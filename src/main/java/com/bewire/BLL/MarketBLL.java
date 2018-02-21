package com.bewire.BLL;

import com.bewire.DAL.CurrencyDAO;
import com.bewire.DAL.MarketDAO;
import com.bewire.Models.Market;
import com.bewire.PL.DTO.MarketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarketBLL implements IMarketBLL {
    @Autowired
    MarketDAO marketDAO;
    @Autowired
    CurrencyDAO currencyDAO;

    @Override
    public List<Market> getAllPayMarketByCurrencyId(int id) {
        return marketDAO.findAllByPayCurrencyId(id);
    }

    @Override
    public List<Market> getAllBuyMarketByCurrencyId(int id) {
        return marketDAO.findAllByBuyCurrencyId(id);
    }

    @Override
    public List<MarketDTO> getAllByExchangeIdAndAndBuyCurrencyId(int exchangeId, int currencyId) {
        List<MarketDTO> markets=new ArrayList<>();

        marketDAO.getAllByExchangeIdAndAndBuyCurrencyId(exchangeId, currencyId).
                forEach(market -> markets.add(new MarketDTO(market,currencyDAO.findCurrencyById(market.getPayCurrencyId()))));

        return markets;
    }

    @Override
    public List<MarketDTO> getAllByExchangeIdAndAndPayCurrencyId(int exchangeId, int currencyId) {
        List<MarketDTO> markets=new ArrayList<>();
        marketDAO.getAllByExchangeIdAndAndPayCurrencyId(exchangeId,currencyId).
                forEach(market -> markets.add(new MarketDTO(market,currencyDAO.findCurrencyById(market.getBuyCurrencyId()))));
        return markets;
    }
}
