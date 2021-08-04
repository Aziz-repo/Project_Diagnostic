package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private String marque;
    private String modele;
    private String email;
    private String nom;
    private String telephone;
    private String date;
    private int nbrReservation;
    
    //constructors
    public Rendez_vous(){

    }
    public Rendez_vous(String date, String marque, String modele){
        this.date = date;
        this.marque = marque;
        this.modele = modele;
    }
    public Rendez_vous(String marque, String modele, String email, String nom, String telephone, String date) {
        this.marque = marque;
        this.modele = modele;
        this.email = email;
        this.nom = nom;
        this.telephone = telephone;
        this.date = date;
    }

    
   
    
    //getters
    public Long getid(){return this.id;}
    public String getmarque(){return this.marque;}
    public String getmodele(){return this.modele;}
    public String getdate(){return this.date;}
    public String getnom(){return this.nom;}
    public String getemail(){return this.email;}
    public String gettelephone(){return this.telephone;}
    public int getnbrReservation(){return this.nbrReservation;}
    //setters
    public void setid(Long r_id){this.id = r_id;}
    public void setdate(String date){this.date = date;}
    public void setmarque(String marque){this.marque = marque;}
    public void setmodele(String modele){this.modele = modele;}
    public void setnom(String nom){this.nom = nom;}
    public void setemail(String email){this.email = email;}
    public void settelephone(String telephone){this.telephone = telephone;}
    public void setnbrResrvation(int nbrReservation){this.nbrReservation = nbrReservation;}
    

    //printing 
    @Override
    public String toString() {
        return "Rendez_vous [date=" + date + ", email=" + email + ", id=" + id + ", marque=" + marque + ", modele="
                + modele + ", nom=" + nom + ", telephone=" + telephone + "]";
    }
}   
