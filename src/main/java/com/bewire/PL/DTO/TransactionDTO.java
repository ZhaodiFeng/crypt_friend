package com.bewire.PL.DTO;

import java.math.BigDecimal;

public class TransactionDTO {
    private int buyCurrencyId;
    private int payCurrencyId;
    private int walletId;
    private BigDecimal buyAmount;
    private BigDecimal payAmount;
    private int marketId;

    public TransactionDTO() {
    }

    public TransactionDTO(int buyCurrencyId, int payCurrencyId, int walletId, BigDecimal buyAmount, BigDecimal payAmount, int marketId) {
        this.buyCurrencyId = buyCurrencyId;
        this.payCurrencyId = payCurrencyId;
        this.walletId = walletId;
        this.buyAmount = buyAmount;
        this.payAmount = payAmount;
        this.marketId = marketId;
    }

    public int getBuyCurrencyId() {
        return buyCurrencyId;
    }

    public void setBuyCurrencyId(int buyCurrencyId) {
        this.buyCurrencyId = buyCurrencyId;
    }

    public int getPayCurrencyId() {
        return payCurrencyId;
    }

    public void setPayCurrencyId(int payCurrencyId) {
        this.payCurrencyId = payCurrencyId;
    }

    public int getWalletId() {
        return walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }

    public BigDecimal getBuyAmount() {
        return buyAmount;
    }

    public void setBuyAmount(BigDecimal buyAmount) {
        this.buyAmount = buyAmount;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public int getMarketId() {
        return marketId;
    }

    public void setMarketId(int marketId) {
        this.marketId = marketId;
    }
}
