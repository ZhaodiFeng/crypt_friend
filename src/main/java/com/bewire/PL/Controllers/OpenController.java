package com.bewire.PL.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/open")
public class OpenController {

    @RequestMapping("header")
    public String header(){
        return "header";
    }
}
