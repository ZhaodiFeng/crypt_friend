package com.bewire.BLL;

import com.bewire.DAL.AssetDAO;
import com.bewire.DAL.TransactionDAO;
import com.bewire.DAL.TransactionTypeDAO;
import com.bewire.Models.Asset;
import com.bewire.Models.Transaction;
import com.bewire.PL.DTO.TransactionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Locale;

@Service
public class TransactionBLL implements ITransactionBLL {
    @Autowired
    private TransactionDAO transactionDAO;
    @Autowired
    private AssetDAO assetDAO;
    @Autowired
    private TransactionTypeDAO transactionTypeDAO;

    @Override
    public void procesTransaction(TransactionDTO transaction) {
        Asset buy=assetDAO.findByWalletIdAndCurrencyId(transaction.getWalletId(),transaction.getBuyCurrencyId());
        if(buy==null)
            buy = new Asset(transaction.getWalletId(),transaction.getBuyCurrencyId());
        Asset pay=assetDAO.findByWalletIdAndCurrencyId(transaction.getWalletId(),transaction.getBuyCurrencyId());
        if(pay==null)
            pay = new Asset(transaction.getWalletId(),transaction.getBuyCurrencyId());
        buy.setAmount(buy.getAmount().add(transaction.getBuyAmount()));
        pay.setAmount(pay.getAmount().add(transaction.getPayAmount().negate()));
        assetDAO.save(buy);
        assetDAO.save(pay);

        Transaction record=new Transaction();
        record.setBuyAmount(transaction.getBuyAmount());
        record.setPayAmount(transaction.getPayAmount());
        record.setBuyAssetId(buy.getId());
        record.setPayAssetId(pay.getId());
        record.setMarketId(transaction.getMarketId());
        record.setDate(new Timestamp(System.currentTimeMillis()));
    }
}
