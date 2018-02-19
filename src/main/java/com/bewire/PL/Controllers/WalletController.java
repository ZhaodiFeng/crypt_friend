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
        model.addAttribute("wallets",walletBLL.getWalletsOfUser(sub));
        return "walletsList";
    }

    @GetMapping("{id}")
    public String getWallet(@PathVariable int id, Model model,Principal principal){
        String sub= UserDetailTool.getUserId(principal);
        if(authenticationBLL.authenticateWallet(id,sub)){
            model.addAttribute("wallet",walletBLL.getWalletAssets(id));
            return "walletOverview";
        }
        else
            return "redirect:/403";
    }

    @GetMapping("{id}/assets/add")
    public  String addAsset(@PathVariable int id, Model model,Principal principal){
        String sub= UserDetailTool.getUserId(principal);
        if(authenticationBLL.authenticateWallet(id,sub)){
            Asset asset=new Asset();
            asset.setWalletId(id);
            model.addAttribute("asset",asset);
            model.addAttribute("wallet",walletBLL.getWallet(id));
            return "walletAddAsset";
        }
        else
            return "redirect:/403";
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
