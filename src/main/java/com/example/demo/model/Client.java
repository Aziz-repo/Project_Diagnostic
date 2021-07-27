package com.example.demo.model;



import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "client")
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
    private Long cin;
    private String email;
    private String password;
    private Long telephone;
    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Rendez_vous> rendez_vous = new ArrayList<>();

    public Client(){

    }
    public Client(String nom, Long telephone, String email) {
        this.nom = nom;
        this.telephone = telephone;
        this.email = email;
    }
    public Client(Long id, String nom, String prenom, Long cin ,String email,String password, Long telephone, List<Rendez_vous> rendez_vous){
        this.id = id;
        this.nom = nom;
        this.cin = cin;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.telephone = telephone;
        this.rendez_vous = rendez_vous;
    
    }
    public Client(String nom, String prenom, Long cin,String email,String password, Long telephone, List<Rendez_vous> rendez_vous){
        this.nom = nom;
        this.cin = cin;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.telephone = telephone;
        this.rendez_vous = rendez_vous;
    }
    public Client(String nom, String prenom, Long cin,String email,String password, Long telephone) {
        this.nom = nom;
        this.cin = cin;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.telephone = telephone;
    }
    //getters
    public Long getId(){return this.id;}
    public String getNom(){return this.nom;}
    public String getPrenom(){return this.prenom;}
    public Long getcin(){return this.cin;}
    public String getEmail(){return this.email;}
    public String getpassword(){return this.password;}
    public Long gettelephone(){return this.telephone;}
    public List<Rendez_vous> getrendezvous(){return this.rendez_vous;}
    //setters
    public void setId(Long id){this.id = id;}
    public void setNom(String nom){this.nom = nom;}
    public void setPrenom(String prenom){this.prenom = prenom;}
    public void setcin(Long cin){this.cin = cin;}
    public void setEmail(String email){this.email = email;}
    public void setpassword(String password){this.password = password;}
    public void settelephone(Long telephone){this.telephone = telephone;}
    public void setrendezvous(List<Rendez_vous> rendez_vous){this.rendez_vous = rendez_vous;}
    
    //Printing
    @Override
    public String toString(){
        return "Client{"+ "nom = "+ nom + " prenom = "+ prenom +" cin = " + cin + " email = "+ email + "password = "+ password+" N° telephone = " + telephone + '}';


    }

    
    
}
