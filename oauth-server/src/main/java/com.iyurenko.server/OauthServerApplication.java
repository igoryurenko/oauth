package com.iyurenko.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class OauthServerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(OauthServerApplication.class, args);
	}
}
