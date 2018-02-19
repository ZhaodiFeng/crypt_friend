package com.bewire.BLL;

import com.bewire.Models.Asset;
import com.bewire.PL.DTO.AssetCurrencyDTO;

import java.util.List;

public interface IAssetBLL {
    void addAsset(Asset asset);

    AssetCurrencyDTO getAssetCurrency(int id);

    List<Asset> getAllAssetsByCurrency(int currencyId,String userId);
}
