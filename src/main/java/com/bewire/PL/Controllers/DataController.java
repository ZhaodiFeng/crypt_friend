package com.bewire.PL.Controllers;

import com.bewire.BLL.CurrencyBLL;
import com.bewire.BLL.UserAssetsBLL;
import com.bewire.Models.Currency;
import com.bewire.PL.DTO.UserWalletsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/data")
public class DataController {
    @Autowired
    private CurrencyBLL currencyBLL;

    @Autowired
    private UserAssetsBLL userAssetsBLL;

    @GetMapping("currency/all")
    public List<Currency> getAllCurrencies(){
        return currencyBLL.getCurrenciesList();
    }

    @GetMapping("currency/{name}")
    public Currency getCurrencyByName(@PathVariable("name")String name){
        return  currencyBLL.getCurrencyByName(name);
    }

    @GetMapping("currency/filter/{key}")
    public List<Currency> getMatchedCurreny(@PathVariable("key")String key){
        return currencyBLL.filterCurrencyByKey(key);
    }

    @GetMapping("currency/top/{number}")
    public List<Currency> getTopCurrencies(@PathVariable("number")int number){
        return currencyBLL.getTopCurrencies(number);
    }

    @RequestMapping("assets")
    public UserWalletsDTO assets(Principal principal){
        OAuth2Authentication authentication=(OAuth2Authentication) principal;
        Map<String,Object> map= (Map<String, Object>) authentication.getUserAuthentication().getDetails();
        return userAssetsBLL.getUserWallets((String)map.get("sub"));
    }
}
