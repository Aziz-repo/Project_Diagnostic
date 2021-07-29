package com.example.demo.Repository;

import java.util.List;

import com.example.demo.model.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepositrory extends JpaRepository<Client,Long> {
   /**
    * Fetch client by email
    * @param email the object email
    */  
   List<Client> findClientByEmail(String email);
   /**
    * Fetch client by identity card
    * @param cin number of the identity card
    */
   List<Client> findClientBycin(Long cin);
   /**
    * Fetch client by phone number
    * @param telephone
    */
   List<Client> findClientBytelephone(String telephone);
   /**
    * Fetch client by email and password
    * @param Login
    * @param password
    * @return a list of clients objects
    */
   List<Client> findClientByEmailAndPassword(String Login, String password);
    
}
