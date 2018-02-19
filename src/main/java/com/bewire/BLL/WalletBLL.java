package com.bewire.BLL;

import com.bewire.DAL.AssetDAO;
import com.bewire.DAL.WalletDAO;
import com.bewire.Models.Asset;
import com.bewire.Models.Wallet;
import com.bewire.PL.DTO.AssetCurrencyDTO;
import com.bewire.PL.DTO.WalletAssetsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WalletBLL implements IWalletBLL {
    @Autowired
    private WalletDAO walletDAO;
    @Autowired
    private AssetBLL assetBLL;
    @Autowired
    private AssetDAO assetDAO;

    @Override
    public void addWallet(Wallet wallet) {
        walletDAO.save(wallet);
    }

    @Override
    public WalletAssetsDTO getWalletAssets(int id) {
        Wallet wallet=walletDAO.findOne( id);
        List<AssetCurrencyDTO> assets=new ArrayList<>();
        assetDAO.findAllByWalletId(id).forEach
                (asset -> assets.add(assetBLL.getAssetCurrency(asset.getId())));
        return new WalletAssetsDTO(assets,wallet);
    }

    @Override
    public Wallet getWallet(int id) {
        return walletDAO.findOne(id);
    }

    @Override
    public void deletWallet(int id) {
        walletDAO.delete(id);
    }

    @Override
    public List<Wallet> getWalletsOfUser(String id) {
        return walletDAO.findAllByUserId(id);
    }

}
