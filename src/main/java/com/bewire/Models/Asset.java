package com.bewire.Models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(AssetPK.class)
public class Asset {
    private int userId;
    private int currencyId;
    private int amount;

    @Id
    @Column(name = "UserId")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Id
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asset asset = (Asset) o;
        return userId == asset.userId &&
                currencyId == asset.currencyId &&
                amount == asset.amount;
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, currencyId, amount);
    }
}
