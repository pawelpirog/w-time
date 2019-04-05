package com.pablo.back.controllers;


import com.pablo.back.model.Worker;
import com.pablo.back.other.NickError;
import com.pablo.back.repository.WorkerRepository;
import com.pablo.back.service.WorkerService;
//import jdk.nashorn.internal.ir.RuntimeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/api/workers")
@CrossOrigin                        //sprawdzic czy zadziala b ez
public class WorkerC {


    public static final Logger logger = LoggerFactory.getLogger(WorkerC.class);

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


        workerRepository.save(new Worker(1,"Paweł","Piróg","pp","mk"));
        //worker.add(new Worker(1,"Paweł","Piróg","pp","mk"));
        //workers.add(new Worker(2,"Tomasz","Krajowy","tt","kk"));
    }


@RequestMapping("/all")
    public List<Worker> getAll(){return workerRepository.findAll();}





        @RequestMapping(value="/login", method=RequestMethod.GET)
        public boolean login(@RequestBody Worker worker) {

           if( worker.getNick().equals("user") && worker.getHaslo().equals("password")){
               System.out.println("jest ok");
           }else System.out.println("nie jest ok");


            return
                    worker.getNick().equals("user") && worker.getHaslo().equals("password");
        }//hardcoded

//
//        @RequestMapping(value = "/login", method = RequestMethod.POST)
//        public String verifyLogin(RequestParam String id){
//
//        }











        @RequestMapping("/user")
        public Principal user(HttpServletRequest request) {
            String authToken = request.getHeader("Authorization")
                    .substring("Basic".length()).trim();
            return () ->  new String(Base64.getDecoder()
                    .decode(authToken)).split(":")[0];
        }

}
