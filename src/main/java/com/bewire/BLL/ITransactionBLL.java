package com.bewire.BLL;

import com.bewire.Models.Asset;
import com.bewire.Models.Transaction;

public interface ITransactionBLL {
    void procesTransaction(Transaction transaction);
}
