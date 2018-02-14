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
    private WalletBLL walletBLL;
    @Autowired
    private UserDAO userDAO;

    @Transactional
    public UserWalletsDTO getUserWallets(String id){
       List<Wallet> wallets= walletDAO.findAllByUserId(id);
       List<WalletAssetsDTO> walletAssetsDTOS=new ArrayList<WalletAssetsDTO>();

       for (int i=0;i<wallets.size();i++) {
            walletAssetsDTOS.add(walletBLL.getWalletAssets(wallets.get(i).getId()));
       }

       return new UserWalletsDTO(userDAO.findFirstById(id),walletAssetsDTOS);
    }

}

