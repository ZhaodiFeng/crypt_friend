package com.bewire.PL.Controllers;

import com.bewire.BLL.AuthenticationBLL;
import com.bewire.BLL.TransactionBLL;
import com.bewire.Models.Transaction;
import com.bewire.PL.DTO.TransactionDTO;
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

    @GetMapping("")
    public String newTransaction(@RequestParam int walletId , Model model){
        TransactionDTO transaction=new TransactionDTO();
        transaction.setWalletId(walletId);
        model.addAttribute("transaction",transaction);
        return "transaction";
    }

    @PostMapping("")
    public String postTransaction(@ModelAttribute TransactionDTO transaction, Principal principal){
        if(authenticationBLL.authenticateTransaction(transaction,principal)){
            transactionBLL.procesTransaction(transaction);
            return "wallet";
        }
        else
            return "redirect:/";
    }
}
