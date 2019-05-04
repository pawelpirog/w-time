package com.pablo.back.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Worker implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long workerID;

    private String email;
    private String imie;
    private String nazwisko;
    private String nick;

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    private String haslo;

    public String getPrzelozony() {
        return przelozony;
    }

    public void setPrzelozony(String przelozony) {
        this.przelozony = przelozony;
    }

    private String przelozony;


    public ArrayList<String> getWorkers() {
        return workers;
    }

    private ArrayList<String> workers;

    public Worker() {
    }

    public Worker(int workerID, String imie, String nazwisko, String nick, String haslo, ArrayList<String> workers) {
        this.workerID = workerID;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nick = nick;
        this.haslo = haslo;
        this.workers = workers;


    }


    //@JoinColumn(name="delegacja_id")

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "worker", cascade = CascadeType.ALL)
    private List<Delegacja> delegacjas;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "worker", cascade = CascadeType.ALL)
    //  @JoinColumn(name="tydzien_roboczy")
    private List<TydzienRoboczy> tydzienRoboczies;


    public Worker(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }


    public Worker(String imie, String nazwisko, String nick, String haslo) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nick = nick;
        this.haslo = haslo;
        workers = new ArrayList<>();

    }

    public Worker(String imie, String nazwisko, String nick, String haslo, String email) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nick = nick;
        this.haslo = haslo;
        workers = new ArrayList<>();
        this.email = email;

    }


    public long getWorkerID() {
        return workerID;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getNick() {
        return nick;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setWorkerID(int workerID) {
        this.workerID = workerID;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }
}
