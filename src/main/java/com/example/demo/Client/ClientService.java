package com.example.demo.Client;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.IllegalStateException;



@Service
public class ClientService {
    private final ClientRepositrory clientRepositrory;
    
    @Autowired
    public ClientService(ClientRepositrory clientRepositrory){
        this.clientRepositrory = clientRepositrory;
    }
    /**
     * Fetch all the Objects
     * @return List of Objects
     */
    public List<Client> get_client(){
        return clientRepositrory.findAll(); 
    }
    /**
     * Delete Object by it's Id in the database
     * @param clientId
     */
    public void delete_client(Long clientId){
        boolean exists = clientRepositrory.existsById(clientId);
        if(!exists){
            throw new IllegalStateException("Ce client n'existe pas");
        }
        clientRepositrory.deleteById(clientId);
    }
    /**
     * Add new Object in the database
     * @param client
     */
    public void addNewClient(Client client){
        List<Client> EmailList = clientRepositrory.findClientByEmail(client.getEmail());
        List<Client> TelephoneList = clientRepositrory.findClientBytelephone(client.gettelephone());
        List<Client> CinList = clientRepositrory.findClientBycin(client.getcin());
        if(!EmailList.isEmpty() || !TelephoneList.isEmpty() || !CinList.isEmpty()){
            throw new IllegalStateException("Donnée(s) déja utilisée(s).Veuillez de verifier votre données!!");
        }
        clientRepositrory.save(client);
        System.out.println(client);
    }
    @Transactional
    /**
     * Update Object data in the database
     * @param clientId Object id on the database
     * @param nom Object last name
     * @param prenom Object first name
     * @param cin Object identity card number
     * @param voiture Object car type
     * @param email Object email
     * @param telephone Object phone number
     */
    public void updateClient(Long clientId,String nom, String prenom, Integer cin, String voiture, String email, Integer telephone){
        Client client= clientRepositrory.findById(clientId).orElseThrow(()->  new IllegalStateException("Client n'existe pas!!"));
        if(nom != null && !Objects.equals(client.getNom(), nom) && nom.length() > 0){
            client.setNom(nom);
        }
        if(prenom != null && !Objects.equals(client.getPrenom(), prenom) && prenom.length() > 0){
            client.setNom(prenom);
        }
        if(cin != null && !Objects.equals(client.getcin(), cin)){
            client.setcin(cin);
        }
        if(voiture != null && !Objects.equals(client.getvoiture(), voiture) && voiture.length() > 0){
            client.setvoiture(voiture);
        }
        if(email != null && !Objects.equals(client.getEmail(), nom) && email.length() > 0){
            client.setEmail(email);
        }
        if(telephone != null && !Objects.equals(client.gettelephone(), telephone)){
            client.settelephone(telephone);
        }
    }
     

    


        
        
    
    
    
}
