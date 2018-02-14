package com.bewire.PL.DTO;

import com.bewire.Models.Asset;
import com.bewire.Models.Currency;

public class AssetCurrencyDTO {
    private Currency currency;
    private Asset asset;

    public AssetCurrencyDTO(Currency currencyName, Asset asset) {
        this.currency = currencyName;
        this.asset = asset;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currencyName) {
        this.currency = currencyName;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }
}
