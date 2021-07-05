package com.example.demo.Client;



import java.io.Serializable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.example.demo.Voiture.Voiture;


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
    private Voiture voiture;
    private String email;
    private int telephone;

    public Client(){

    }
    public Client(Long id, String nom, String prenom, int cin, Voiture voiture,String email, int telephone){
        this.id = id;
        this.nom = nom;
        this.cin = cin;
        this.prenom = prenom;
        this.voiture = voiture;
        this.email = email;
        this.telephone = telephone;
    }
    public Client(String nom, String prenom, int cin, Voiture voiture,String email, int telephone){
        this.nom = nom;
        this.cin = cin;
        this.prenom = prenom;
        this.voiture = voiture;
        this.email = email;
        this.telephone = telephone;
    }
    //getters
    public Long getId(){return this.id;}
    public String getNom(){return this.nom;}
    public String getPrenom(){return this.prenom;}
    public int getcin(){return this.cin;}
    @Embedded
    public Voiture getvoiture(){return this.voiture;}
    public String getEmail(){return this.email;}
    public int gettelephone(){return this.telephone;}
    
    //setters
    public void setId(Long id){this.id = id;}
    public void setNom(String nom){this.nom = nom;}
    public void setPrenom(String prenom){this.prenom = prenom;}
    public void setcin(Integer cin){this.cin = cin;}
    public void setvoiture(Voiture voiture){this.voiture = voiture;}
    public void setEmail(String email){this.email = email;}
    public void settelephone(Integer telephone){this.telephone = telephone;}
    
    //Printing
    @Override
    public String toString(){
        return "Client{"+ "nom = "+ nom + " prenom = "+ prenom +" cin = " + cin + " voiture = " + voiture + " email = "+ email + " N° telephone = " + telephone + '}';


    }

    
    
}
