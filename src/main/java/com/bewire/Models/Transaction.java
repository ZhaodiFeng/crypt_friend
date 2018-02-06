package com.bewire.Models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Transaction {
    private int id;
    private int currencyId;
    private int amount;
    private int dateTime;
    private Market marketByMarketId;
    private Trade tradeByTradeId;

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "CurrencyId")
    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }

    @Basic
    @Column(name = "Amount")
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "DateTime")
    public int getDateTime() {
        return dateTime;
    }

    public void setDateTime(int dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return id == that.id &&
                currencyId == that.currencyId &&
                amount == that.amount &&
                dateTime == that.dateTime;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, currencyId, amount, dateTime);
    }

    @ManyToOne
    @JoinColumn(name = "MarketId", referencedColumnName = "Id", nullable = false)
    public Market getMarketByMarketId() {
        return marketByMarketId;
    }

    public void setMarketByMarketId(Market marketByMarketId) {
        this.marketByMarketId = marketByMarketId;
    }

    @ManyToOne
    @JoinColumn(name = "TradeId", referencedColumnName = "Id", nullable = false)
    public Trade getTradeByTradeId() {
        return tradeByTradeId;
    }

    public void setTradeByTradeId(Trade tradeByTradeId) {
        this.tradeByTradeId = tradeByTradeId;
    }
}
