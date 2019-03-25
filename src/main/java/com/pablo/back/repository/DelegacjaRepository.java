package com.pablo.back.repository;

import com.pablo.back.model.Delegacja;
import com.pablo.back.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DelegacjaRepository extends JpaRepository<Delegacja, Long> {
    List<Delegacja> findAllByWorker(Worker worker);

}
