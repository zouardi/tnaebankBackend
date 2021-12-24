package com.TNABank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Bean;
// import org.springframework.web.servlet.config.annotation.CorsRegistry;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.TNABank.*" })
@SpringBootApplication
public class TnaBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(TnaBankApplication.class, args);
	}
	
	
	// TODO: enable cors globaly ?
	/*
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api");
			}
		};
	}
	*/

}
