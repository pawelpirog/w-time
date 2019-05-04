package com.pablo.back.repository;

import com.pablo.back.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerRepository extends JpaRepository <Worker, Long> {
    //List<Worker> findAllBy



    public Worker findWorkerByWorkerID(long id);
    public Worker findWorkerByNick(String nick);

}




