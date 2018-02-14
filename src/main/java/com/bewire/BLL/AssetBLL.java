package com.bewire.BLL;

import com.bewire.DAL.AssetDAO;
import com.bewire.DAL.CurrencyDAO;
import com.bewire.Models.Asset;
import com.bewire.Models.Currency;
import com.bewire.PL.DTO.AssetCurrencyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetBLL implements IAssetBLL {
    @Autowired
    private AssetDAO assetDAO;
    @Autowired
    private CurrencyDAO currencyDAO;
    @Override
    public void addAsset(Asset asset) {
        assetDAO.save(asset);
    }

    @Override
    public AssetCurrencyDTO getAssetCurrency(int id) {
        Asset asset=assetDAO.findOne(id);
        Currency currency=currencyDAO.findCurrencyById(asset.getCurrencyId());
        return new AssetCurrencyDTO(currency,asset);
    }
}
