package com.bewire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class CryptFriendApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CryptFriendApplication.class, args);
	}
}
