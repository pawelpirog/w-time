//
//package com.pablo.back.other;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.security.SecurityProperties;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//
//@Configuration
//@EnableWebSecurity
//@Order(SecurityProperties.DEFAULT_FILTER_ORDER)
//public class BasicAuthConfiguration extends WebSecurityConfigurerAdapter {
//
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth)
////            throws Exception {
////        auth
////                .inMemoryAuthentication()
////                .withUser("2")
////                .password("1")
////                .roles("USER", "ADMIN");
////
////
////
////    }
//
//    @Override
//    protected void configure(HttpSecurity http)
////            throws Exception {
//
//        http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/login").permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic().disable();
//
//
//
//
//
//
//
//        http.authorizeRequests().antMatchers("/").permitAll();
//    }
////
////
////
////
//////		@Override
//////		protected void configure(HttpSecurity http) throws Exception {
//////			http
//////					.httpBasic()
//////					.and()
//////					.authorizeRequests()
//////					.antMatchers("/index.html", "/", "/workers", "/login").permitAll()
//////					.anyRequest().authenticated();
//////		}
////
////
////	@Override
////	protected void configure(HttpSecurity http) throws Exception {
////		http.csrf().disable().
////
////				authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/**").permitAll().anyRequest().authenticated()
////				.and().httpBasic();
////	}
////
////	@Autowired
////	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////		auth.inMemoryAuthentication().withUser("javainuse").password("{noop}password").roles("USER");
////	}
////
////
////	}
////
////
////
////
