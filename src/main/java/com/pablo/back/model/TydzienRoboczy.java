package com.pablo.back.model;



import javax.persistence.*;
import java.util.Date;

@Entity
public class TydzienRoboczy {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private Date dataOd;
    private Date dataDo;
    @ManyToOne(fetch = FetchType.LAZY)
    private Worker worker;


    public TydzienRoboczy(Date dataOd, Date dataDo, Worker worker) {
        this.dataOd = dataOd;
        this.dataDo = dataDo;    
  //      this.worker = worker;
    }

    public TydzienRoboczy() {
    }
int t=5;
    public TydzienRoboczy(Date dataOd, Date dataDo) {
        this.dataOd = dataOd;
        this.dataDo = dataDo;

    }
}
