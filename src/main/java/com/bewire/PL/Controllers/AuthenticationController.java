package com.bewire.PL.Controllers;


import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
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

    @RequestMapping("/sub")
    public String profile(Principal principal) throws IOException {
        OAuth2Authentication authentication=(OAuth2Authentication) principal;

        String sub="Error";
        sub= new ObjectMapper().writeValueAsString(authentication.getUserAuthentication().getDetails());

        return sub.split(",")[0].split(":")[1].replace("\"", "");
    }
}
