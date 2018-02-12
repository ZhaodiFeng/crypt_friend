package com.bewire.PL.Controllers;

import com.bewire.BLL.IUserAssetsBLL;
import com.bewire.BLL.UserAssetsBLL;
import com.bewire.DAL.AssetDAO;
import com.bewire.DAL.WalletDAO;
import com.bewire.Models.Asset;
import com.bewire.Models.Wallet;
import com.bewire.PL.DTO.UserWalletsDTO;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/assets")
public class AssetsController {
    @Autowired
    private AssetDAO assetDAO;
    @Autowired
    private WalletDAO walletDAO;
    @Autowired
    private UserAssetsBLL userAssetsBLL;

    @RequestMapping("assets")
    public UserWalletsDTO assets(Principal principal){
        OAuth2Authentication authentication=(OAuth2Authentication) principal;
        String sub="";
        try {
            sub= new ObjectMapper().writeValueAsString(authentication.getUserAuthentication().getDetails());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String id=sub.split(",")[0].split(":")[1].replace("\"", "");

        return userAssetsBLL.getAllWalletsAndAssets(id);
    }

}
