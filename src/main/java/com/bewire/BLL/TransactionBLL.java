package com.bewire.BLL;

import com.bewire.DAL.AssetDAO;
import com.bewire.DAL.TransactionDAO;
import com.bewire.DAL.TransactionTypeDAO;
import com.bewire.Models.Asset;
import com.bewire.Models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionBLL implements ITransactionBLL {
    @Autowired
    private TransactionDAO transactionDAO;
    @Autowired
    private AssetDAO assetDAO;
    @Autowired
    private TransactionTypeDAO transactionTypeDAO;

    @Override
    @Transactional
    public void procesTransaction(Transaction transaction) {
        int transactionId=transaction.getTransactionTypeId();
        if(transactionId==transactionTypeDAO.findFirstByName("Init"))
            procesInit(transaction);
        if (transactionId==transactionTypeDAO.findFirstByName("Trade"))
            procesTrade(transaction);
    }

    private void procesInit(Transaction transaction){
        Asset asset=assetDAO.findOne(transaction.getBuyAssetId());
        asset.setAmount(transaction.getBuyAmount());
        assetDAO.save(asset);
    }

    private void procesTrade(Transaction transaction){
        Asset pay=assetDAO.findOne(transaction.getPayAssetId());
        Asset buy=assetDAO.findOne(transaction.getBuyAssetId());
        pay.setAmount(pay.getAmount().min(transaction.getPayAmount()));
        buy.setAmount(buy.getAmount().add(transaction.getBuyAmount()));
        assetDAO.save(pay);
        assetDAO.save(buy);
    }
}
