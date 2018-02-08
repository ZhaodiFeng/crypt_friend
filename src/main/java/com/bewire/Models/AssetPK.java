package com.bewire.Models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class AssetPK implements Serializable {
    private int id;
    private int currencyId;

    @Column(name = "Id", nullable = false)
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "Currency_Id", nullable = false)
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
        return id == assetPK.id &&
                currencyId == assetPK.currencyId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, currencyId);
    }
}
