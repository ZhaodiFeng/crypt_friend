package com.bewire.PL.DTO;

import com.bewire.Models.Asset;

public class AssetCurrencyDTO {
    private String currencyName;
    private Asset asset;

    public AssetCurrencyDTO(String currencyName, Asset asset) {
        this.currencyName = currencyName;
        this.asset = asset;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }
}
