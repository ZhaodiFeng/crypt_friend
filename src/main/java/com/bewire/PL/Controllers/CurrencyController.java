package com.bewire.PL.Controllers;

import com.bewire.BLL.CurrencyBLL;
import com.bewire.BLL.IMarketApiBLL;

import com.bewire.PL.DTO.BittrexCurrenciesCurrencyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
    @Autowired
    private IMarketApiBLL bittrexCurrencyBLL;
    @Autowired
    private CurrencyBLL currencyBLL;
    @Autowired
    private IMarketApiBLL marketApiBLL;

    @RequestMapping("/")
    public String getCurrenciesList(Model model){
        model.addAttribute("currencies",currencyBLL.getCurrenciesList());
        return "currenciesList";
    }

    @RequestMapping("/update")
    public String updateCurrenciesList() throws IOException {
        marketApiBLL.UpdateCurrenciesList();
        return "redirect:/currency";
    }

}
