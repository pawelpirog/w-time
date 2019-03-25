//package com.pablo.back.viewmodels;
//
//import com.pablo.back.model.Delegacja;
//import com.pablo.back.model.TydzienRoboczy;
//
//import javax.persistence.*;
//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotNull;
//import java.util.ArrayList;
//import java.util.List;
//
//
//@Entity
//public class Worker {
//
//    Worker(){}
//    Worker(String imie, String nazwisko){this.imie=imie;this.nazwisko=nazwisko;}
//
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long id;
//
//
//    @NotNull
//    private String imie;
//
//    @NotNull
//    private String nazwisko;
//    @NotNull
//    private String nick;
//    @NotNull
//    @Min(6)
//    private String haslo;
//
//
//
//
//
//    public String getImie() {
//        return imie;
//    }
//
//    public String getNazwisko() {
//        return nazwisko;
//    }
//
//    public String getNick() {
//        return nick;
//    }
//
//    public String getHaslo() {
//        return haslo;
//    }
//
//
//    public void setImie(String imie) {
//        this.imie = imie;
//    }
//
//    public void setNazwisko(String nazwisko) {
//        this.nazwisko = nazwisko;
//    }
//
//    public void setNick(String nick) {
//        this.nick = nick;
//    }
//
//    public void setHaslo(String haslo) {
//        this.haslo = haslo;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//}
