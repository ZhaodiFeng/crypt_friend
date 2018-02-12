package com.bewire.PL.DTO;

import com.bewire.Models.Wallet;

import java.util.List;

public class WalletAssetsDTO {
    private  List<AssetCurrencyDTO> assets;
    private Wallet wallet;

    public WalletAssetsDTO(List<AssetCurrencyDTO> assets, Wallet wallet) {
        this.assets = assets;
        this.wallet = wallet;
    }

    public List<AssetCurrencyDTO> getAssets() {
        return assets;
    }

    public void setAssets(List<AssetCurrencyDTO> assets) {
        this.assets = assets;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
}
