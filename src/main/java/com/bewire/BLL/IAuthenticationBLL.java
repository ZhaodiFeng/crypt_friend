package com.bewire.BLL;

import com.bewire.Models.Transaction;
import com.bewire.PL.DTO.TransactionDTO;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import java.security.Principal;
import java.util.Map;

public interface IAuthenticationBLL {
    boolean authenticateTransaction(TransactionDTO transaction, Principal principal);
    boolean authenticateWallet(int walletId,String userId);
    boolean authenticateAsset(int assetId,String userId);

}
