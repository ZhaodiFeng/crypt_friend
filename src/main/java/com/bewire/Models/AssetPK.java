package com.bewire.Models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class AssetPK implements Serializable {
    private int userId;
    private int currencyId;

    @Column(name = "UserId")
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "CurrencyId")
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
        return userId == assetPK.userId &&
                currencyId == assetPK.currencyId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, currencyId);
    }
}
