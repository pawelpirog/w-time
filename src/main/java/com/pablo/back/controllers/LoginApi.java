package com.pablo.back.controllers;

import com.pablo.back.model.Worker;
import com.pablo.back.repository.WorkerRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
//@RequestMapping("/")
//@CrossOrigin
@CrossOrigin(origins = "http://localhost:4200")
public class LoginApi {


    WorkerRepository workerRepository;

//    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @PostMapping("login")
    public String login(@RequestBody Worker worker){


        long curr=System.currentTimeMillis();

        //todo wanze!
        //checking whether a user exists in database!!!!
        //i returnuje usera albo kierownika w zaleznosci od danych.




     //   if(worker.getNick()!=null && workerRepository.findWorkerByNick(worker.getNick()).getHaslo().equals(worker.getHaslo())) {

        System.out.println("fsdgbsf");
        System.out.println(worker.getNick());
        System.out.println(worker.getHaslo());
        System.out.println("hahaha");

        String key= Jwts.builder()
                    .setSubject(worker.getNick())
                    .claim("roles", "user")
                    .setIssuedAt(new Date(curr))
                    .setExpiration(new Date(curr + 600000))  //10 minut
                    .signWith(SignatureAlgorithm.HS256, "haggggggfgfgfgf")
                    .compact();

        System.out.println(key+"to moj klucz");
        return key;

    }


//    public Authentication getAuthentication(String token) {
//        UserDetails userDetails = this.userDetailsService.loadUserByUsername(getUsername(token));
//        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
//    }


}
