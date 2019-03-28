package com.pablo.back.service;

import com.pablo.back.model.Worker;
import com.pablo.back.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkerService {


    @Autowired
    WorkerRepository workerRepository;

    public Worker save(Worker user) {
        return workerRepository.saveAndFlush(user);
    }

    public Worker update(Worker user) {
        return workerRepository.save(user);
    }

    public Worker find(String userName) {
        return workerRepository.findWorkerByUsername(userName);
    }

//    public Worker find(Long id) {
//        return workerRepository.findOne(id);
//    }
}



