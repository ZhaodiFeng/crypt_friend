package com.bewire.BLL;

import com.bewire.DAL.AssetDAO;
import com.bewire.DAL.TransactionTypeDAO;
import com.bewire.DAL.WalletDAO;
import com.bewire.Models.Asset;
import com.bewire.Models.Transaction;
import com.bewire.Models.TransactionType;
import com.bewire.Models.Wallet;
import com.bewire.Utilities.UserDetailTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Map;

@Service
public class AuthenticationBLL implements  IAuthenticationBLL {
    @Autowired
    private TransactionTypeDAO transactionTypeDAO;
    @Autowired
    private WalletDAO walletDAO;
    @Autowired
    private AssetDAO assetDAO;

    @Override
    public boolean authenticateTransaction(Transaction transaction, Principal principal) {
        TransactionType transactionType=transactionTypeDAO.findOne( transaction.getTransactionTypeId());
        String sub= UserDetailTool.getUserId(principal);

        if (transactionType.getName().equals("Init")){
           return authenticateAsset(transaction.getBuyAssetId(),sub);
        }
        if (transactionType.getName().equals("Trade")){
            return authenticateAsset(transaction.getBuyAssetId(),sub)
                    &&authenticateAsset(transaction.getPayAssetId(),sub);
        }
        return false;
    }

    @Override
    public boolean authenticateWallet(int walletId,String userId){
        Wallet wallet=walletDAO.findOne( walletId);
        if(!wallet.getUserId().equals(userId))
            return false;
        else
            return true;
    }

    @Override
    public boolean authenticateAsset(int assetId,String userId){
        Asset asset=assetDAO.findOne( assetId);
        Wallet wallet=walletDAO.findOne( asset.getWalletId());
        return authenticateWallet(wallet.getId(),userId);
    }

}
