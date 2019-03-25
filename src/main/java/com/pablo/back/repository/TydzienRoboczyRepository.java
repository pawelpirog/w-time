package com.pablo.back.repository;

import com.pablo.back.model.TydzienRoboczy;
import com.pablo.back.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TydzienRoboczyRepository extends JpaRepository<TydzienRoboczy, Long> {
    List<TydzienRoboczy> findAllByWorker(Worker worker);
}
