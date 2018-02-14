package com.bewire.PL.Controllers;

import com.bewire.BLL.IMarketApiBLL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private IMarketApiBLL marketApiBLL;

    @RequestMapping("update")
    public String updateCurrenciesList() throws IOException {
        marketApiBLL.UpdateCurrenciesList();
        return "redirect:/currency";
    }

}
