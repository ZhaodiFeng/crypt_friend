package com.bewire.BLL;

import com.bewire.Models.Asset;
import com.bewire.PL.DTO.AssetCurrencyDTO;

public interface IAssetBLL {
    void addAsset(Asset asset);

    AssetCurrencyDTO getAssetCurrency(int id);
}
