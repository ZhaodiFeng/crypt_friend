package com.bewire.PL.Controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by fengz on 05-Feb-18.
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String indx(Authentication authentication){
        return "index";
    }
}
