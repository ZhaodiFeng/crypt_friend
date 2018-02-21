package com.bewire.PL.Controllers;

import com.bewire.BLL.IAuthenticationBLL;
import com.bewire.BLL.IWalletBLL;
import com.bewire.Models.Asset;
import com.bewire.PL.DTO.WalletAssetsDTO;
import com.bewire.Utilities.UserDetailTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/wallet")
public class WalletController {
    @Autowired
    private IAuthenticationBLL authenticationBLL;
    @Autowired
    private IWalletBLL walletBLL;

    @GetMapping("")
    public String getAllWallets(Principal principal,Model model){
        String sub=UserDetailTool.getUserId(principal);
        model.addAttribute("wallet",walletBLL.getWalletAssets( walletBLL.getWalletsOfUser(sub).get(0).getId()));
        return "walletOverview";
    }

    @PostMapping("{id}/delete")
    public String deleteWallet(@PathVariable int id,Principal principal){
        String sub=UserDetailTool.getUserId(principal);
        if (authenticationBLL.authenticateWallet(id,sub)){
            walletBLL.deletWallet(id);
            return "/asset";
        }
        else
            return "redirect:/403";
    }
}
