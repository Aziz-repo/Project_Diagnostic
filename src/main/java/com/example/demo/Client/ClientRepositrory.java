package com.example.demo.Client;

import java.util.List;
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
   List<Client> findClientBycin(Integer cin);
   /**
    * Fetch client by phone number
    * @param telephone
    */
   List<Client> findClientBytelephone(Integer telephone);
    
}
