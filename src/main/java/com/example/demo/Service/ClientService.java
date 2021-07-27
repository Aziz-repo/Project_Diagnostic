package com.example.demo.Service;


import java.util.List;
import java.util.Objects;


import javax.transaction.Transactional;
import com.example.demo.Exeption.ApiRequestException;
import com.example.demo.Repository.ClientRepositrory;
import com.example.demo.model.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



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
    public List<Client> getClientByCin(Long cin){
        return clientRepositrory.findClientBycin(cin);
    }
    public List<Client> getClientByEmail(String email) {
        return clientRepositrory.findClientByEmail(email);
    }
    /**
     * Delete Object by it's Id in the database
     * @param clientId
     */
    public void delete_client(Long clientId){
        boolean exists = clientRepositrory.existsById(clientId);
        if(!exists){
            throw new ApiRequestException("Ce client n'existe pas");
        }
        clientRepositrory.deleteById(clientId);
    }
    /**
     * Encrypt the password using Bcrypt encryption
     * @param password
     * @return String
     */
    public String encrypt(String password) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10);
        return bCryptPasswordEncoder.encode(password);
    
    }
    /**
     * Add new Object in the database
     * @param client
     */
    public void addNewClient(Client client){
        String password;
        String encryptedPassword;
        List<Client> EmailList = clientRepositrory.findClientByEmail(client.getEmail());
        List<Client> TelephoneList = clientRepositrory.findClientBytelephone(client.gettelephone());
        List<Client> CinList = clientRepositrory.findClientBycin(client.getcin());
        if(!EmailList.isEmpty() || !TelephoneList.isEmpty() || !CinList.isEmpty()){
            throw new ApiRequestException("Donnée(s) déja utilisée(s)! Veuillez de vérifier vos donné(s)!!");
        }
        /**Encrypt password**/
        password = client.getpassword();
        encryptedPassword = encrypt(password);
        client.setpassword(encryptedPassword);
        /**save the client**/
        clientRepositrory.save(client);
    }
    
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
    @Transactional
    public void updateClient(Long clientId,String nom, String prenom, Long cin, String voiture,String password, String email, Long telephone){
        Client client= clientRepositrory.findById(clientId).orElseThrow(()->  new ApiRequestException("Ce client n'existe pas!!"));
        if(nom != null && !Objects.equals(client.getNom(), nom) && nom.length() > 0){
            client.setNom(nom);
        }
        if(prenom != null && !Objects.equals(client.getPrenom(), prenom) && prenom.length() > 0){
            client.setNom(prenom);
        }
        if(cin != null && !Objects.equals(client.getcin(), cin)){
            client.setcin(cin);
        }
        if(email != null && !Objects.equals(client.getEmail(), nom) && email.length() > 0){
            client.setEmail(email);
        }
        if(password != null && !Objects.equals(client.getpassword(),password) && password.length() > 0) {
            client.setpassword(password);
        }
        if(telephone != null && !Objects.equals(client.gettelephone(), telephone)){
            client.settelephone(telephone);
        }
    }
    public boolean authenticate(String Login, String password) {
        String encrypted_password;
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10);
        List<Client> client = clientRepositrory.findClientByEmail(Login);
        if(!client.isEmpty()) {
            encrypted_password = client.get(0).getpassword();
            return bCryptPasswordEncoder.matches(password, encrypted_password);
        }
        return false;
   
            
        
    }
    
     

    


        
        
    
    
    
}
