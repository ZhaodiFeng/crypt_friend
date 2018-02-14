package com.bewire.BLL;

import com.bewire.Models.Transaction;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import java.security.Principal;
import java.util.Map;

public interface IAuthenticationBLL {
    boolean authenticateTransaction(Transaction transaction, Principal principal);
    boolean authenticateWallet(int walletId,String userId);
    boolean authenticateAsset(int assetId,String userId);

}
