package com.bewire.PL.Controllers;

import com.bewire.BLL.UserAssetsBLL;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.security.Principal;

@Controller
@RequestMapping("/profile")
public class Profile {
    @Autowired
    private UserAssetsBLL userAssetsBLL;

    @RequestMapping("/")
    public String overview(Principal principal, Model model){
        OAuth2Authentication authentication=(OAuth2Authentication) principal;
        String sub="";
        try {
            sub= new ObjectMapper().writeValueAsString(authentication.getUserAuthentication().getDetails());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String id=sub.split(",")[0].split(":")[1].replace("\"", "");

        model.addAttribute("overview",userAssetsBLL.getAllWalletsAndAssets(id));
        return "profile";
    }

}
