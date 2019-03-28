package com.pablo.back.controllers;


import com.pablo.back.model.TydzienRoboczy;

import com.pablo.back.repository.TydzienRoboczyRepository;
import com.pablo.back.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/tydzienroboczy")
@CrossOrigin
public class TydzienRoboczyC {

    private List<TydzienRoboczy> tydzienRoboczies;
    private TydzienRoboczyRepository tydzienRoboczyRepository;


    @Autowired
    public TydzienRoboczyC(TydzienRoboczyRepository tydzienRoboczyRepository) {
        this.tydzienRoboczyRepository = tydzienRoboczyRepository;

        //workers.add(new Worker(1,"Paweł","Piróg","pp","mk"));
        //workers.add(new Worker(2,"Tomasz","Krajowy","tt","kk"));
    }


    @RequestMapping("/all")
    public List<TydzienRoboczy> getAll(){return tydzienRoboczyRepository.findAll();}




}


