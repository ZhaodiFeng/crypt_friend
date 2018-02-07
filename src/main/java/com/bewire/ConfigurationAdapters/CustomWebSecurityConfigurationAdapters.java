package com.bewire.ConfigurationAdapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.test.OAuth2ContextConfiguration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

/**
 * Created by fengz on 05-Feb-18.
 */

@Configuration
@EnableOAuth2Sso
public class CustomWebSecurityConfigurationAdapters extends WebSecurityConfigurerAdapter {
    @Autowired
    CustomAuthenticationSuccessHandeler successHandeler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/", "/login", "/webjars/**","/css/**","/open/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and().logout().logoutSuccessUrl("/").permitAll()
                .and().formLogin().successHandler(successHandeler);
    }

}
