package com.bewire.PL.Controllers;


import com.bewire.Models.User;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.security.Principal;
import java.util.Map;

/**
 * Created by fengz on 05-Feb-18.
 */
@RestController
public class AuthenticationController {
    @RequestMapping("/user")
    public Principal user(Principal principal){
        return principal;
    }

    @RequestMapping("/roles")
    public Object user() {
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities();
    }


    @RequestMapping("/sub")
    public String profile(Principal principal)  {
        OAuth2Authentication authentication=(OAuth2Authentication) principal;

        String sub="Error";
        Map<String,Object> map= (Map<String, Object>) authentication.getUserAuthentication().getDetails();

        return (String)map.get("sub");
    }

    @RequestMapping("/unauthenticated")
    public ModelAndView unauthenticated(){
        return new ModelAndView("redirect:/login");
    }
}
