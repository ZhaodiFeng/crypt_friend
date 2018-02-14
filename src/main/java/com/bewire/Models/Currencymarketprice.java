package com.bewire.Models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "currency_market_price", schema = "crypt_friend", catalog = "")
public class CurrencyMarketPrice {
    private int id;
    private int saleCurrencyId;
    private int buyCurrencyId;
    private int marketId;
    private int price;
    private Timestamp updateTime;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Column(name = "Sale_Currency_Id", nullable = false)
    public int getSaleCurrencyId() {
        return saleCurrencyId;
    }

    public void setSaleCurrencyId(int saleCurrencyId) {
        this.saleCurrencyId = saleCurrencyId;
    }


    @Column(name = "Buy_Currency_Id", nullable = false)
    public int getBuyCurrencyId() {
        return buyCurrencyId;
    }

    public void setBuyCurrencyId(int buyCurrencyId) {
        this.buyCurrencyId = buyCurrencyId;
    }


    @Column(name = "Market_Id", nullable = false)
    public int getMarketId() {
        return marketId;
    }

    public void setMarketId(int marketId) {
        this.marketId = marketId;
    }


    @Column(name = "Price", nullable = false, precision = 0)
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Column(name = "Update_Time", nullable = false)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyMarketPrice that = (CurrencyMarketPrice) o;
        return id == that.id &&
                saleCurrencyId == that.saleCurrencyId &&
                buyCurrencyId == that.buyCurrencyId &&
                marketId == that.marketId &&
                price == that.price &&
                Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, saleCurrencyId, buyCurrencyId, marketId, price, updateTime);
    }
}
