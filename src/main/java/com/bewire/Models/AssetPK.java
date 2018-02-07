package com.bewire.Models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class AssetPK implements Serializable {
    private String userId;
    private int currencyId;

    @Column(name = "UserId", nullable = false, length = 21)
    @Id
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Column(name = "CurrencyId", nullable = false)
    @Id
    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssetPK assetPK = (AssetPK) o;
        return currencyId == assetPK.currencyId &&
                Objects.equals(userId, assetPK.userId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, currencyId);
    }
}
