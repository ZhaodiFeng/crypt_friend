package com.bewire.ConfigurationAdapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.oauth2.client.test.OAuth2ContextConfiguration;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.Filter;


/**
 * Created by fengz on 05-Feb-18.
 */

@Configuration
@EnableOAuth2Client
public class CustomWebSecurityConfigurationAdapters extends WebSecurityConfigurerAdapter {

    @Qualifier("oauth2ClientContext")
    @Autowired
    OAuth2ClientContext oauth2ClientContext;

    @Autowired
    CustomAuthenticationSuccessHandeler customAuthenticationSuccessHandeler;

    @Bean
    @ConfigurationProperties("security.oauth2.client")
    public AuthorizationCodeResourceDetails oauth2(){
        return new AuthorizationCodeResourceDetails();
    }

    @Bean
    @ConfigurationProperties("security.oauth2.resource")
    public ResourceServerProperties oauth2Resource(){
        return new ResourceServerProperties();
    }

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
                .and().addFilterBefore(ssoFilter(), BasicAuthenticationFilter.class);

    }

    private Filter ssoFilter(){
        OAuth2ClientAuthenticationProcessingFilter googleFilter = new OAuth2ClientAuthenticationProcessingFilter("/login");
        OAuth2RestTemplate googleTemplate = new OAuth2RestTemplate(oauth2(), oauth2ClientContext);
        googleFilter.setRestTemplate(googleTemplate);
        UserInfoTokenServices tokenServices = new UserInfoTokenServices(oauth2Resource().getUserInfoUri(), oauth2().getClientId());
        tokenServices.setRestTemplate(googleTemplate);
        googleFilter.setTokenServices(tokenServices);
        googleFilter.setAuthenticationSuccessHandler(customAuthenticationSuccessHandeler);
        return googleFilter;
    }

    @Bean
    public FilterRegistrationBean oauth2ClientFilterRegistration(
            OAuth2ClientContextFilter filter) {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(filter);
        registration.setOrder(-100);
        return registration;
    }



}
