package com.bewire.PL.Controllers;

import com.bewire.BLL.CurrencyBLL;
import com.bewire.BLL.MarketBLL;
import com.bewire.BLL.UserAssetsBLL;
import com.bewire.Models.Currency;
import com.bewire.Models.Market;
import com.bewire.PL.DTO.CurrencyFilterJSONDTO;
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

    @Autowired
    private MarketBLL marketBLL;

    @GetMapping("market/buy/{currencyId}")
    public List<Market> getBuyMarketsForCurrency(@PathVariable("currencyId")int id){
        return marketBLL.getAllBuyMarketByCurrencyId(id);
    }

    @GetMapping("market/pay/{currencyId}")
    public List<Market> getPayMarketsForCurrency(@PathVariable("currencyId")int id){
        return marketBLL.getAllPayMarketByCurrencyId(id);
    }

    @GetMapping("currency/all")
    public CurrencyFilterJSONDTO getAllCurrencies(){
        CurrencyFilterJSONDTO dto=new CurrencyFilterJSONDTO();
        dto.setQuery("all");
        dto.setSuggestions(currencyBLL.getCurrenciesList());
        return dto;
    }

    @GetMapping("currency/{name}")
    public Currency getCurrencyByName(@PathVariable("name")String name){
        return  currencyBLL.getCurrencyByName(name);
    }

    @GetMapping("currency/filter/{key}")
    public CurrencyFilterJSONDTO  getMatchedCurreny(@PathVariable("key")String key){
        CurrencyFilterJSONDTO dto=new CurrencyFilterJSONDTO();
        dto.setQuery(key);
        dto.setSuggestions(currencyBLL.filterCurrencyByKey(key));
        return dto;
    }

    @GetMapping("currency/top/{number}")
    public CurrencyFilterJSONDTO  getTopCurrencies(@PathVariable("number")int number){
        CurrencyFilterJSONDTO dto=new CurrencyFilterJSONDTO();
        dto.setQuery("Top"+number);
        dto.setSuggestions(currencyBLL.getTopCurrencies(number));
        return dto;
    }

    @RequestMapping("assets")
    public UserWalletsDTO assets(Principal principal){
        OAuth2Authentication authentication=(OAuth2Authentication) principal;
        Map<String,Object> map= (Map<String, Object>) authentication.getUserAuthentication().getDetails();
        return userAssetsBLL.getUserWallets((String)map.get("sub"));
    }
}
