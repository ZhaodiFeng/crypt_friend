package com.bewire.PL.Controllers;

import com.bewire.DAL.AssetDAO;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.security.Principal;

@Controller

public class ProfileController {
    @Autowired
    private AssetDAO assetDAO;

    @RequestMapping("/profile")
    public String profile(Principal principal,Model model){
        OAuth2Authentication authentication=(OAuth2Authentication) principal;
        String sub="";
        try {
            sub= new ObjectMapper().writeValueAsString(authentication.getUserAuthentication().getDetails());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String id=sub.split(",")[0].split(":")[1].replace("\"", "");
        model.addAttribute("assets",assetDAO.findByUserId(id));
        return "profile";
    }

}
