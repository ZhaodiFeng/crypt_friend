package com.bewire.ConfigurationAdapters;

import com.bewire.DAL.RoleDAO;
import com.bewire.DAL.UserDAO;
import com.bewire.DAL.UserRoleDAO;
import com.bewire.Models.User;
import com.bewire.Models.UserRole;
import org.codehaus.jackson.map.ObjectMapper;
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
import java.util.Map;

@Component
public class CustomAuthenticationSuccessHandeler extends
        SavedRequestAwareAuthenticationSuccessHandler {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private UserRoleDAO userRoleDAO;
    @Autowired
    private RoleDAO roleDAO;

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
        OAuth2Authentication auth=(OAuth2Authentication)authentication;
        Map<String,Object> map= (Map<String, Object>) auth.getUserAuthentication().getDetails();
        String id=(String)map.get("sub");
        String name=(String)map.get("name");
        String email=(String)map.get("email");

        if (!userDAO.existsById(id)){
            User user=new User();
            user.setId(id);
            user.setName(name);
            user.setMailAdres(email);
            userDAO.save(user);

            UserRole userRole=new UserRole();
            userRole.setRoleId(roleDAO.findRoleByName("User").getId());
            userRole.setUserId(id);
            userRoleDAO.save(userRole);
        }
    }
}
