package com.bewire.PL.DTO;

public class BittrexCurrenciesCurrencyDTO {
    private String Currency;
    private String CurrencyLong;
    private int MinConfirmation;
    private double TxFee;
    private boolean IsActive;
    private String CoinType;
    private String BaseAddress;
    private String Notice;


    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String currency) {
        Currency = currency;
    }

    public String getCurrencyLong() {
        return CurrencyLong;
    }

    public void setCurrencyLong(String currencyLong) {
        CurrencyLong = currencyLong;
    }

    public int getMinConfirmation() {
        return MinConfirmation;
    }

    public void setMinConfirmation(int minConfirmation) {
        MinConfirmation = minConfirmation;
    }

    public double getTxFee() {
        return TxFee;
    }

    public void setTxFee(double txFee) {
        TxFee = txFee;
    }

    public boolean isActive() {
        return IsActive;
    }

    public void setActive(boolean active) {
        IsActive = active;
    }

    public String getCoinType() {
        return CoinType;
    }

    public void setCoinType(String coinType) {
        CoinType = coinType;
    }

    public String getBaseAddress() {
        return BaseAddress;
    }

    public void setBaseAddress(String baseAddress) {
        BaseAddress = baseAddress;
    }

    public String getNotice() {
        return Notice;
    }

    public void setNotice(String notice) {
        Notice = notice;
    }
}
