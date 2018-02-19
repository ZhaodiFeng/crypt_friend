package com.bewire.Models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
public class Transaction {
    private int id;
    private int transactionTypeId;
    private int marketId;
    private int fee;
    private int buyAssetId;
    private int payAssetId;
    private BigDecimal buyAmount;
    private BigDecimal payAmount;
    private Date date;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Column(name = "Transaction_Type_Id", nullable = false)
    public int getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(int transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }


    @Column(name = "Market_Id", nullable = true)
    public int getMarketId() {
        return marketId;
    }

    public void setMarketId(int marketId) {
        this.marketId = marketId;
    }


    @Column(name = "Fee", nullable = true, precision = 15,scale = 4)
    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "Buy_Asset_Id", nullable = true)
    public int getBuyAssetId() {
        return buyAssetId;
    }

    public void setBuyAssetId(int buyAssetId) {
        this.buyAssetId = buyAssetId;
    }


    @Column(name = "Pay_Asset_Id", nullable = true)
    public int getPayAssetId() {
        return payAssetId;
    }

    public void setPayAssetId(int saleAssetId) {
        this.payAssetId = saleAssetId;
    }


    @Column(name = "Buy_Amount", nullable = true, precision = 15,scale = 4)
    public BigDecimal getBuyAmount() {
        return buyAmount;
    }

    public void setBuyAmount(BigDecimal buyAmount) {
        this.buyAmount = buyAmount;
    }


    @Column(name = "Pay_Amount", nullable = true, precision = 15,scale = 4)
    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal saleAmount) {
        this.payAmount = saleAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return id == that.id &&
                transactionTypeId == that.transactionTypeId &&
                fee == that.fee &&
                Objects.equals(buyAssetId, that.buyAssetId) &&
                Objects.equals(payAssetId, that.payAssetId) &&
                Objects.equals(buyAmount, that.buyAmount) &&
                Objects.equals(payAmount, that.payAmount);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, transactionTypeId, marketId, fee, buyAssetId, payAssetId, buyAmount, payAmount);
    }
}
