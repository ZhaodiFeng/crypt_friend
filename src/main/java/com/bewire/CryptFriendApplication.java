package com.bewire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class CryptFriendApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CryptFriendApplication.class, args);
			}


	@Bean
	public EmbeddedServletContainerCustomizer customizer() {
		return container -> {
			container.addErrorPages(new ErrorPage(HttpStatus.valueOf(403), "/unauthenticated"));
		};
	}
}
