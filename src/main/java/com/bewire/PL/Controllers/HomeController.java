package com.bewire.PL.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by fengz on 05-Feb-18.
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String indx(){
        return "index";
    }
}
