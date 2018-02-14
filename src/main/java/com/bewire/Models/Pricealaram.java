package com.bewire.Models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "price_alaram", schema = "crypt_friend", catalog = "")
public class PriceAlaram {
    private int id;
    private String userId;
    private int saleCurrencyId;
    private int buyCurrencyId;
    private int marketId;
    private int price;
    private Timestamp expirationTime;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Column(name = "User_Id", nullable = false, length = 21)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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


    @Column(name = "Expiration_Time", nullable = false)
    public Timestamp getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Timestamp expirationTime) {
        this.expirationTime = expirationTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceAlaram that = (PriceAlaram) o;
        return id == that.id &&
                saleCurrencyId == that.saleCurrencyId &&
                buyCurrencyId == that.buyCurrencyId &&
                marketId == that.marketId &&
                price == that.price &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(expirationTime, that.expirationTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userId, saleCurrencyId, buyCurrencyId, marketId, price, expirationTime);
    }
}
