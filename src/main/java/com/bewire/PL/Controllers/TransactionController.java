package com.bewire.PL.Controllers;

import com.bewire.BLL.AuthenticationBLL;
import com.bewire.BLL.TransactionBLL;
import com.bewire.BLL.WalletBLL;
import com.bewire.Models.Asset;
import com.bewire.Models.Transaction;
import com.bewire.PL.DTO.TransactionDTO;
import com.bewire.Utilities.UserDetailTool;
import com.sun.org.apache.xpath.internal.operations.Mod;
import netscape.security.ForbiddenTargetException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private AuthenticationBLL authenticationBLL;
    @Autowired
    private TransactionBLL transactionBLL;
    @Autowired
    private WalletBLL walletBLL;


    @GetMapping("")
    public String newTransaction(Model model){
        TransactionDTO transaction=new TransactionDTO();
        model.addAttribute("transaction",transaction);
        model.addAttribute("asset",new Asset());
        return "transaction";
    }

    @PostMapping("")
    public String postTransaction(@ModelAttribute TransactionDTO transaction, Principal principal){
        transaction.setWalletId(walletBLL.getWalletsOfUser(UserDetailTool.getUserId(principal)).get(0).getId());
        if(authenticationBLL.authenticateTransaction(transaction,principal)){
            transactionBLL.procesTransaction(transaction);
            return "redirect:/wallet";
        }
        else
            return "redirect:/";
    }
}
