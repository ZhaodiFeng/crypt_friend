package com.bewire.Models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Currencymarketprice {
    private int id;
    private int price;
    private Timestamp updateTime;
    private Currency currencyBySaleCurrencyId;
    private Currency currencyByBuyCurrencyId;

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Basic
    @Column(name = "UpdateTime")
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
        Currencymarketprice that = (Currencymarketprice) o;
        return id == that.id &&
                price == that.price &&
                Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, price, updateTime);
    }

    @ManyToOne
    @JoinColumn(name = "SaleCurrencyId", referencedColumnName = "Id", nullable = false)
    public Currency getCurrencyBySaleCurrencyId() {
        return currencyBySaleCurrencyId;
    }

    public void setCurrencyBySaleCurrencyId(Currency currencyBySaleCurrencyId) {
        this.currencyBySaleCurrencyId = currencyBySaleCurrencyId;
    }

    @ManyToOne
    @JoinColumn(name = "BuyCurrencyId", referencedColumnName = "Id", nullable = false)
    public Currency getCurrencyByBuyCurrencyId() {
        return currencyByBuyCurrencyId;
    }

    public void setCurrencyByBuyCurrencyId(Currency currencyByBuyCurrencyId) {
        this.currencyByBuyCurrencyId = currencyByBuyCurrencyId;
    }
}
