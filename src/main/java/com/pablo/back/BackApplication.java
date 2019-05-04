package com.pablo.back;

import com.pablo.back.controllers.JWTFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
//
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.security.Principal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BackApplication {



//	@Bean
//	public FilterRegistrationBean filterRegistrationBean()
//	{
//		FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
//		filterRegistrationBean.setFilter(new JWTFilter());
//		filterRegistrationBean.setUrlPatterns(Collections.singleton("/workers/*"));		//todo naprawic bo  nie dziala
//
//		return filterRegistrationBean;

	//}




	public static void main(String[] args) {
		SpringApplication.run(BackApplication.class, args);
	}

}
