package com.bewire.Models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(AssetPK.class)
public class Asset {
    private String userId;
    private int currencyId;
    private int amount;

    @Id
    @Column(name = "UserId", nullable = false, length = 21)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "CurrencyId", nullable = false)
    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }

    @Basic
    @Column(name = "Amount", nullable = false, precision = 0)
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asset asset = (Asset) o;
        return currencyId == asset.currencyId &&
                amount == asset.amount &&
                Objects.equals(userId, asset.userId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, currencyId, amount);
    }
}
