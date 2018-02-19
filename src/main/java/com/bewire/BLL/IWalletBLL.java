package com.bewire.BLL;

import com.bewire.Models.Wallet;
import com.bewire.PL.DTO.WalletAssetsDTO;

import java.util.List;

public interface IWalletBLL {
    void addWallet(Wallet wallet);
    WalletAssetsDTO getWalletAssets(int id);
    Wallet getWallet(int id);
    void deletWallet(int id);
    List<Wallet> getWalletsOfUser(String  id);
}
