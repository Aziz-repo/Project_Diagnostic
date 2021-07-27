package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "rendez_vous")
public class Rendez_vous implements Serializable {
    
    
    @Id
    @SequenceGenerator(
        name = "rendez_vous_sequence",
        sequenceName = "rendez_vous_sequence",
        allocationSize = 1

    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "rendez_vous_sequence"
        )
    private Long id;
    String marque;
    String modele;
    private String date;
    @ManyToOne      
    private Client client;
    
    public Rendez_vous(){

    }
    public Rendez_vous( String date){
        this.date = date;
    }
    public Rendez_vous(Client client) {
        this.client = client;
    }
    public Rendez_vous(String date, Client client) {
        this.client = client;
        this.date = date;
    }
    //getters
    public Long getid(){return this.id;}
    public String getmarque(){return this.marque;}
    public String getmodele(){return this.modele;}
    public String getdate(){return this.date;}
    public Client getclient(){return this.client;}
    //setters
    public void setid(Long r_id){this.id = r_id;}
    public void setdate(String date){this.date = date;}
    public void setclient(Client client){this.client = client;}
    public void setmarque(String marque){this.marque = marque;}
    public void setmodele(String modele){this.modele = modele;}

    @Override
    public String toString() {
        return "Rendez_vous [client=" + client + ", date=" + date + ", id=" + id + "]";}
}   
