package com.example.demo.Client;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path="api/v1/FirstProject")
public class ClientController {
    
    private final ClientService clientService;
    @Autowired
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @GetMapping //Get
    public List<Client> get_client(){
        System.out.println("Client sauvgardé");//testing purposes
        return clientService.get_client();
    }
    @DeleteMapping(path = "{clientId}") //Delete
    public void delete_client(@PathVariable("clientId") Long clientId){
        clientService.delete_client(clientId);
        System.out.println("Client supprimé");//testing purposes
    }
    @PostMapping(path = "/addClient") //Post
    public void registerClient(@RequestBody Client client){
        clientService.addNewClient(client);
    }
    @PutMapping(path = "{clientId}") //Put
    public void updateClient(@PathVariable("clientId") Long clientId,
    @RequestParam(required = false) String nom,
    @RequestParam(required = false) String prenom,
    @RequestParam(required = false) Integer cin,
    @RequestParam(required = false) String voiture,
    @RequestParam(required = false) String email,
    @RequestParam(required = false) Integer telephone){
        clientService.updateClient(clientId,nom,prenom,cin,voiture,email,telephone);
        
    

    }
   
}

    
    
    
   

    
    

