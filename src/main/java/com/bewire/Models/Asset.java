package com.bewire.Models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(AssetPK.class)
public class Asset {
    private int id;
    private int walletId;
    private int currencyId;
    private int amount;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Wallet_Id", nullable = false)
    public int getWalletId() {
        return walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }

    @Id
    @Column(name = "Currency_Id", nullable = false)
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
        return id == asset.id &&
                walletId == asset.walletId &&
                currencyId == asset.currencyId &&
                amount == asset.amount;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, walletId, currencyId, amount);
    }
}
