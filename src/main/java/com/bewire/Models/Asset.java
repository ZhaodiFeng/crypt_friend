package com.bewire.Models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Asset {
    private int id;
    private int walletId;
    private int currencyId;
    private BigDecimal amount;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Column(name = "Wallet_Id", nullable = false)
    public int getWalletId() {
        return walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }


    @Column(name = "Currency_Id", nullable = false)
    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }


    @Column(name = "Amount", nullable = false)
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
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
