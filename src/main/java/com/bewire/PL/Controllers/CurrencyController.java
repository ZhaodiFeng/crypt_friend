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

@Controller
@RequestMapping("/currency")
public class CurrencyController {
    @Autowired
    private CurrencyBLL currencyBLL;

    @RequestMapping("")
    public String getCurrenciesList(Model model){
        model.addAttribute("currencies",currencyBLL.getCurrenciesList());
        return "currenciesList";
    }



}
