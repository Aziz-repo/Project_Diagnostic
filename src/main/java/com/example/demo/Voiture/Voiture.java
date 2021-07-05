package com.example.demo.Voiture;

import javax.persistence.Embeddable;

@Embeddable
public class Voiture {
    private String marque;
    private String modele;
    private int cate_grise;

    public Voiture(){}

    public Voiture(String marque, String modele, int carte_grise){
        this.marque = marque;
        this.modele = modele;
        this.cate_grise = carte_grise;

    }
    //getters
    public String getmarque(){return this.marque;}
    public String getmodele(){return this.modele;}
    public int getcarte_grise(){return this.cate_grise;}
    //helper
    public boolean equals(Voiture other){
        if(this.marque!=other.marque || this.modele!=other.modele || this.cate_grise!= other.cate_grise){
            return false;
        }
        return true;
    }   
}

