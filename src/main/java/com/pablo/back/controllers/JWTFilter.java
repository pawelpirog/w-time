package com.pablo.back.controllers;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
//import java.net.http.HttpRequest;

@CrossOrigin(origins = "http://localhost:4200")
public class JWTFilter implements javax.servlet.Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {




        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String header = httpServletRequest.getHeader("authorization");
      //  String h2=httpServletRequest.getHe




        Enumeration<String> nana= httpServletRequest.getHeaderNames();
        while(nana.hasMoreElements()){
            System.out.println("kolejny to "+nana.nextElement());
        }




        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;


        //httpServletResponse.setHeader("Access-Control-Allow-Origin",httpServletRequest.getHeader("*"));
//        httpServletResponse.setHeader("Access-Control-Allow-Origin", httpServletRequest.getHeader("Origin"));
//        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
//        httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
//        httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
//        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");



        if (httpServletRequest == null) {
            throw new ServletException("wrong/empty header");
        } else {
            System.out.println("zerio");
            try {
                System.out.println("raz");

                System.out.println(header + " to moj header");
                String token = header.substring(7);
                System.out.println("dwa");

                Claims claims = Jwts.parser().setSigningKey("kozak2").parseClaimsJws(token).getBody();


                servletRequest.setAttribute("claims", claims);


            } catch (Exception e) {
                throw new ServletException("wrong key");
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);


    }


}
