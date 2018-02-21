package com.bewire.PL.DTO;

import com.bewire.Models.Currency;
import com.bewire.Models.Market;

import java.util.List;

public class MarketDTO
{
    private int marketId;
    private String marketName;
    private int currency2Id;
    private String currency2Name;
    private String currency2Symbol;

    public MarketDTO(Market market, Currency currency2) {
        setMarketId(market.getId());
        setMarketName(market.getName());
        setCurrency2Id(currency2.getId());
        setCurrency2Name(currency2.getName());
        setCurrency2Symbol(currency2.getSymbol());
    }

    public String getCurrency2Symbol() {
        return currency2Symbol;
    }

    public void setCurrency2Symbol(String currency2Symbol) {
        this.currency2Symbol = currency2Symbol;
    }

    public int getMarketId() {
        return marketId;
    }

    public void setMarketId(int marketId) {
        this.marketId = marketId;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public int getCurrency2Id() {
        return currency2Id;
    }

    public void setCurrency2Id(int currency2Id) {
        this.currency2Id = currency2Id;
    }

    public String getCurrency2Name() {
        return currency2Name;
    }

    public void setCurrency2Name(String currency2Name) {
        this.currency2Name = currency2Name;
    }
}
