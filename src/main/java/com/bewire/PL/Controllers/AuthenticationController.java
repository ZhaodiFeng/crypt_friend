package com.bewire.PL.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * Created by fengz on 05-Feb-18.
 */
@RestController
public class AuthenticationController {
    @RequestMapping("/user")
    public Principal user(Principal principal){
        return principal;
    }
    }
