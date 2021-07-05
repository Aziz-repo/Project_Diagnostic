package com.example.demo.Client;



import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.example.demo.Rendez_vous.Rendez_vous;
import java.util.List;


@Entity
@Table
public class Client implements Serializable {
    @Id
    @SequenceGenerator(
        name = "client_sequence",
        sequenceName = "client_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "client_sequence"
    )
    private Long id;
    private String nom;
    private String prenom;
    private int cin;
    private String email;
    private int telephone;
    @OneToMany(mappedBy = "client")
    private List<Rendez_vous> rendez_vous;

    public Client(){

    }
    public Client(Long id, String nom, String prenom, int cin ,String email, int telephone, List<Rendez_vous> rendez_vous){
        this.id = id;
        this.nom = nom;
        this.cin = cin;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.rendez_vous = rendez_vous;
    
    }
    public Client(String nom, String prenom, int cin,String email, int telephone, List<Rendez_vous> rendez_vous){
        this.nom = nom;
        this.cin = cin;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.rendez_vous = rendez_vous;
    }
    //getters
    public Long getId(){return this.id;}
    public String getNom(){return this.nom;}
    public String getPrenom(){return this.prenom;}
    public int getcin(){return this.cin;}
    public String getEmail(){return this.email;}
    public int gettelephone(){return this.telephone;}
    public List<Rendez_vous> getrendezvous(){return this.rendez_vous;}
    //setters
    public void setId(Long id){this.id = id;}
    public void setNom(String nom){this.nom = nom;}
    public void setPrenom(String prenom){this.prenom = prenom;}
    public void setcin(Integer cin){this.cin = cin;}
    public void setEmail(String email){this.email = email;}
    public void settelephone(Integer telephone){this.telephone = telephone;}
    public void setrendezvous(List<Rendez_vous> rendez_vous){this.rendez_vous = rendez_vous;}
    
    //Printing
    @Override
    public String toString(){
        return "Client{"+ "nom = "+ nom + " prenom = "+ prenom +" cin = " + cin + " email = "+ email + " N° telephone = " + telephone + '}';


    }

    
    
}
