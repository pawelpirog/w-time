package com.pablo.back.repository;

import com.pablo.back.model.Worker;
import com.pablo.back.model.Delegacja;
import com.pablo.back.model.TydzienRoboczy;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
@ConditionalOnProperty(name="noteit.db.recreate",havingValue = "true")
public class DbSeeder implements CommandLineRunner {

    private WorkerRepository workerRepository;
    private TydzienRoboczyRepository tydzienRoboczyRepository;
    private DelegacjaRepository delegacjaRepository;




    public DbSeeder(WorkerRepository workerRepository, TydzienRoboczyRepository tydzienRoboczyRepository, DelegacjaRepository delegacjaRepository) {
        this.workerRepository = workerRepository;
        this.tydzienRoboczyRepository = tydzienRoboczyRepository;
        this.delegacjaRepository = delegacjaRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        this.workerRepository.deleteAll();
        this.delegacjaRepository.deleteAll();
       this.tydzienRoboczyRepository.deleteAll();


      Worker defaultWorker=new Worker("Jan","Kowalski","pies","piesek", "pies@pies.com");
        workerRepository.save(defaultWorker);

        Worker defaultWorker2=new Worker("Pawel","Nowak","kot","kotek", "kot@pies.com");
        workerRepository.save(defaultWorker2);


//        TydzienRoboczy defaultTydzienRoboczy = new TydzienRoboczy();
//        this.tydzienRoboczyRepository.save(defaultTydzienRoboczy);
//
//        TydzienRoboczy defaultTydzienRoboczy2=new TydzienRoboczy(new Date(2000,2,10),new Date(2000,2,17));
//        this.tydzienRoboczyRepository.save(defaultTydzienRoboczy2);
//
//        Delegacja defaultDelegacja=new Delegacja("kraków");
//        this.delegacjaRepository.save(defaultDelegacja);

        //Delegacja defaultDelegacja2=new Delegacja("warszawa",defaultWorker);



        System.out.println("udalo sie");



    }


}
