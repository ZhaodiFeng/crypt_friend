package com.bewire.BLL;

import com.bewire.DAL.AssetDAO;
import com.bewire.DAL.CurrencyDAO;
import com.bewire.DAL.UserDAO;
import com.bewire.DAL.WalletDAO;
import com.bewire.Models.Asset;
import com.bewire.Models.User;
import com.bewire.Models.Wallet;

import com.bewire.PL.DTO.AssetCurrencyDTO;
import com.bewire.PL.DTO.UserWalletsDTO;
import com.bewire.PL.DTO.WalletAssetsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserAssetsBLL implements IUserAssetsBLL{
    @Autowired
    private WalletDAO walletDAO;
    @Autowired
    private AssetDAO assetDAO;
    @Autowired
    private CurrencyDAO currencyDAO;
    @Autowired
    private UserDAO userDAO;

    @Transactional
    public UserWalletsDTO getAllWalletsAndAssets(String id){
       List<Wallet> wallets= walletDAO.findAllByUserId(id);
       List<WalletAssetsDTO> walletAssetsDTOS=new ArrayList<WalletAssetsDTO>();

       for (int i=0;i<wallets.size();i++) {
            List<Asset> assets=assetDAO.findAllByWalletId(wallets.get(i).getId());
            List<AssetCurrencyDTO> assetCurrencyDTOS=new ArrayList<AssetCurrencyDTO>();

            for (int j=0;j<assets.size();j++) {
                String currencyname=currencyDAO.findCurrencyById(assets.get(j).getCurrencyId()).getName();
                assetCurrencyDTOS.add(new AssetCurrencyDTO(currencyname,assets.get(j)));
            }

            walletAssetsDTOS.add(new WalletAssetsDTO(assetCurrencyDTOS,wallets.get(i)));
       }

       return new UserWalletsDTO(userDAO.findFirstById(id),walletAssetsDTOS);
    }

}

