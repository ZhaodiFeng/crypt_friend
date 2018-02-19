package com.bewire.BLL;

import com.bewire.Models.Asset;
import com.bewire.Models.Transaction;
import com.bewire.PL.DTO.TransactionDTO;

public interface ITransactionBLL {
    void procesTransaction(TransactionDTO transaction);
}
