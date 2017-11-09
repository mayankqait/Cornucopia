package com.infotech.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.infotech.repository")
@Configuration
@ComponentScan("com.infotech")
@EntityScan("com.infotech.model")
@SpringBootApplication
public class CornucopiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CornucopiaApplication.class, args);
	}
}
