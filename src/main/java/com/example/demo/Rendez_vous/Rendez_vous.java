package com.example.demo.Rendez_vous;

import java.time.LocalDate;

import com.example.demo.Client.Client;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.example.demo.Voiture.Voiture;



@Entity
@Table
public class Rendez_vous {
    @Id
    @SequenceGenerator(
        name = "redez_vous_sequence",
        sequenceName = "rendez_vous_sequence",
        allocationSize = 1

    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "rendez_vous_sequence"
        )
    private Long r_id;
    private Voiture voiture;
    private LocalDate date;
    @ManyToOne    
    private Client client;
    
    public Rendez_vous(){

    }
    public Rendez_vous(Voiture voiture, LocalDate date, Client client){
        this.voiture = voiture;
        this.date = date;
        this.client = client;
    }
    //getters
    public Long getid(){return this.r_id;}
    public Voiture getvoiture(){return this.voiture;}
    public LocalDate getdate(){return this.date;}
    public Client getclient(){return this.client;}
    //setters
    public void setid(Long r_id){this.r_id = r_id;}
    public void setvoiture(Voiture voiture){this.voiture = voiture;}
    public void setdate(LocalDate date){this.date = date;}
    public void setclient(Client client){this.client = client;}
}   
