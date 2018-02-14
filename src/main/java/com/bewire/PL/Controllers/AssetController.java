package com.bewire.PL.Controllers;

import com.bewire.BLL.IAssetBLL;
import com.bewire.BLL.IAuthenticationBLL;
import com.bewire.BLL.IUserAssetsBLL;
import com.bewire.Models.Asset;
import com.bewire.Utilities.UserDetailTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

@Controller
@RequestMapping("/asset")
public class AssetController {
    @Autowired
    private IUserAssetsBLL userAssetsBLL;
    @Autowired
    private IAuthenticationBLL authenticationBLL;
    @Autowired
    private IAssetBLL assetBLL;

    @GetMapping("")
    public String overview(Principal principal, Model model){
        OAuth2Authentication authentication=(OAuth2Authentication) principal;
        Map<String,Object> map=(Map<String, Object>) authentication.getUserAuthentication().getDetails();
        model.addAttribute("overview",userAssetsBLL.getUserWallets((String)map.get("sub")));
        return "assetsOverview";
    }

    @PostMapping("")
    public String addAsset(@ModelAttribute Asset asset, Principal principal){
        String userId= UserDetailTool.getUserId(principal);
        if(authenticationBLL.authenticateWallet(asset.getWalletId(),userId)){
            assetBLL.addAsset(asset);
            return "/asset";
        }
        else
            return "redirect:/403";
    }
}
