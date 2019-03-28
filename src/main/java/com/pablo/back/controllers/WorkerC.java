package com.pablo.back.controllers;


import com.pablo.back.model.Worker;
import com.pablo.back.other.NickError;
import com.pablo.back.repository.WorkerRepository;
import com.pablo.back.service.WorkerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/workers")
@CrossOrigin                        //sprawdzic czy zadziala b ez
public class WorkerC {


    public static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private WorkerService workerService;
    private WorkerRepository workerRepository;






    @CrossOrigin
    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody Worker newWorker) {
        if (workerService.find(newWorker.getNick()) != null) {
            logger.error("username Already exist " + newWorker.getNick());
            return new ResponseEntity(
                    new NickError("user with username " + newWorker.getNick() + "already exist "),
                    HttpStatus.CONFLICT);
        }


        return new ResponseEntity<Worker>(workerService.save(newWorker), HttpStatus.CREATED);
    }





    @Autowired
    public WorkerC(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;

        //workers.add(new Worker(1,"Paweł","Piróg","pp","mk"));
        //workers.add(new Worker(2,"Tomasz","Krajowy","tt","kk"));
    }


@RequestMapping("/all")
    public List<Worker> getAll(){return workerRepository.findAll();}





}
