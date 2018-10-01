package com.yash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableJpaRepositories("com.yash.model")
@EntityScan("com.yash")
//@ComponentScan("com.yash.dao")
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);  
	}
	
	
}
