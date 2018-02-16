package com.bewire.Models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "currency_market_price", schema = "crypt_friend")
public class CurrencyMarketPrice {
    private int id;
    private int marketId;
    private BigDecimal price;
    private Timestamp updateTime;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "Market_Id", nullable = false)
    public int getMarketId() {
        return marketId;
    }

    public void setMarketId(int marketId) {
        this.marketId = marketId;
    }


    @Column(name = "Price", nullable = false, precision = 15,scale = 4)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    @Column(name = "Update_Time", nullable = false)
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
        CurrencyMarketPrice that = (CurrencyMarketPrice) o;
        return id == that.id &&
                marketId == that.marketId &&
                price == that.price &&
                Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, marketId, price, updateTime);
    }
}
