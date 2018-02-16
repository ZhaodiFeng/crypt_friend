package com.bewire.PL.Controllers;

import com.bewire.BLL.AuthenticationBLL;
import com.bewire.BLL.TransactionBLL;
import com.bewire.Models.Transaction;
import netscape.security.ForbiddenTargetException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private AuthenticationBLL authenticationBLL;
    @Autowired
    private TransactionBLL transactionBLL;

    @PostMapping("")
    public String postTransaction(@ModelAttribute Transaction transaction, Principal principal){
        if(authenticationBLL.authenticateTransaction(transaction,principal)){
            transactionBLL.procesTransaction(transaction);
            return "redirect:/asset";
        }
        else
            return "redirect:/";
    }
}
