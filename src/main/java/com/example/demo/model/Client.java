package com.example.demo.model;



import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;




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
    private String telephone;
    

    public Client(){

    }
    public Client(String nom, String telephone, String email) {
        this.nom = nom;
        this.telephone = telephone;
        this.email = email;
    }
    public Client(Long id, String nom, String prenom, Long cin ,String email,String password, String telephone){
        this.id = id;
        this.nom = nom;
        this.cin = cin;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.telephone = telephone;
        
    
    }
    public Client(String nom, String prenom, Long cin,String email,String password, String telephone){
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
    public String gettelephone(){return this.telephone;}
    //setters
    public void setId(Long id){this.id = id;}
    public void setNom(String nom){this.nom = nom;}
    public void setPrenom(String prenom){this.prenom = prenom;}
    public void setcin(Long cin){this.cin = cin;}
    public void setEmail(String email){this.email = email;}
    public void setpassword(String password){this.password = password;}
    public void settelephone(String telephone){this.telephone = telephone;}
    
    //Printing
    @Override
    public String toString(){
        return "Client{"+ "nom = "+ nom + " prenom = "+ prenom +" cin = " + cin + " email = "+ email + "password = "+ password+" N° telephone = " + telephone + '}';


    }

    
    
}
