package com.pablo.back.viewmodels;

import com.pablo.back.model.Worker;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.Date;

public class TydzienRoboczyViewModel {


    private long id;
    private Date dataOd;
    private Date dataDo;


    public TydzienRoboczyViewModel() {
    }


    public TydzienRoboczyViewModel(long id, Date dataOd, Date dataDo) {
        this.id = id;
        this.dataOd = dataOd;
        this.dataDo = dataDo;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDataOd(Date dataOd) {
        this.dataOd = dataOd;
    }

    public void setDataDo(Date dataDo) {
        this.dataDo = dataDo;
    }

    public long getId() {
        return id;
    }

    public Date getDataOd() {
        return dataOd;
    }

    public Date getDataDo() {
        return dataDo;
    }
}
