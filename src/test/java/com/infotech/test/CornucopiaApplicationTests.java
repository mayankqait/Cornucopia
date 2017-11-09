package com.infotech.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import com.infotech.main.CornucopiaApplication;


//@RunWith(SpringRunner.class)
//@SpringBootTest
@Configuration
@SpringBootApplication
@ComponentScan("com.infotech")
public class CornucopiaApplicationTests {

	

	public static void main(String[] args) {
		SpringApplication.run(CornucopiaApplication.class, args);
	}

}
