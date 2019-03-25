package com.pablo.back.controllers;


import com.pablo.back.model.Worker;
import com.pablo.back.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/workers")
@CrossOrigin                        //sprawdzic czy zadziala b ez
public class WorkerC {


    private List <Worker> workers;
   private WorkerRepository workerRepository;
private int a=5;


    @Autowired
    public WorkerC(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;

        //workers.add(new Worker(1,"Paweł","Piróg","pp","mk"));
        //workers.add(new Worker(2,"Tomasz","Krajowy","tt","kk"));
    }


@RequestMapping("/all")
    public List<Worker> getAll(){return workerRepository.findAll();}




}
