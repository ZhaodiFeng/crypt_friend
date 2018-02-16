package com.bewire.Models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Market {
    private int id;
    private String name;
    private Integer apiAdres;
    private int buyCurrencyId;
    private int payCurrencyId;
    private int exchangeId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "Buy_Currency_Id",nullable = false)
    public int getBuyCurrencyId() {
        return buyCurrencyId;
    }

    public void setBuyCurrencyId(int buyCurrencyId) {
        this.buyCurrencyId = buyCurrencyId;
    }

    @Column(name ="Pay_Currency_Id",nullable = false)
    public int getPayCurrencyId() {
        return payCurrencyId;
    }

    public void setPayCurrencyId(int payCurrencyId) {
        this.payCurrencyId = payCurrencyId;
    }

    @Column(name = "Exchange_Id")
    public int getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(int exchangeId) {
        this.exchangeId = exchangeId;
    }

    @Column(name = "Name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Column(name = "Api_Adres", nullable = true)
    public Integer getApiAdres() {
        return apiAdres;
    }

    public void setApiAdres(Integer apiAdres) {
        this.apiAdres = apiAdres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Market market = (Market) o;
        return id == market.id &&
                Objects.equals(payCurrencyId,market.payCurrencyId)&&
                Objects.equals(buyCurrencyId,market.buyCurrencyId)&&
                Objects.equals(name, market.name) &&
                Objects.equals(exchangeId,market.exchangeId)&&
                Objects.equals(apiAdres, market.apiAdres);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, apiAdres,buyCurrencyId,payCurrencyId,exchangeId);
    }
}
