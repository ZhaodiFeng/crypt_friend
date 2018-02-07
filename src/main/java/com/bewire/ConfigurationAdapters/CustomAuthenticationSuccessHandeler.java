package com.bewire.ConfigurationAdapters;

import com.bewire.DAL.UserDAO;
import com.bewire.Models.User;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
public class CustomAuthenticationSuccessHandeler extends
        SavedRequestAwareAuthenticationSuccessHandler {
    @Autowired
    private UserDAO userDAO;


    /**
     * Na inloggen, update huidige tijdstamp als lastBezoek
     *
     * @param request        HttpServletRequest
     * @param response       HttpServletResponse
     * @param authentication Authentication
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        super.onAuthenticationSuccess(request, response, authentication);
        //Now add your custom logic to update database
        OAuth2Authentication auth=(OAuth2Authentication)authentication.getPrincipal();
        String[] details= new ObjectMapper().writeValueAsString(auth.getUserAuthentication().getDetails()).split(",");
        String id= Arrays.stream(details).filter(s -> s.contains("sub:"))
                .findFirst().get().split(":")[1].replace("\"","");
        String name= Arrays.stream(details).filter(s -> s.contains("name:"))
                .findFirst().get().split(":")[1].replace("\"","");
        String email= Arrays.stream(details).filter(s -> s.contains("email:"))
                .findFirst().get().split(":")[1].replace("\"","");
        if (!userDAO.existsById(id)){
            User user=new User();
            user.setId(id);
            user.setName(name);
            user.setMailAdres(email);
        }
        System.out.print("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }
}