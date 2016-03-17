package com.iyurenko.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class OauthClientApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(OauthClientApplication.class, args);
	}
}
