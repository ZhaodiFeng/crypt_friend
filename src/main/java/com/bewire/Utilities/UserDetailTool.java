package com.bewire.Utilities;

import org.springframework.security.oauth2.provider.OAuth2Authentication;

import java.security.Principal;
import java.util.Map;

public class UserDetailTool {
    public static String getUserId(Principal principal){
        OAuth2Authentication authentication=(OAuth2Authentication) principal;
        Map<String,Object> map= (Map<String, Object>) authentication.getUserAuthentication().getDetails();
        return (String)map.get("sub");}
}
