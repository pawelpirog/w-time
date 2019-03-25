package com.pablo.back.model;




import javax.persistence.*;
import java.util.Date;

@Entity
public class Delegacja {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String miejsce;
    private Date dataOd;
    private Date dataDo;

    @ManyToOne(fetch = FetchType.LAZY)
    private Worker worker;
    int pp=5;


    public Delegacja(String miejsce) {
        this.miejsce = miejsce;
    }

    public Delegacja() {
    }

    public Delegacja(String miejsce, Worker worker) {
        this.miejsce = miejsce;
 //       this.worker = worker;
    }
}
