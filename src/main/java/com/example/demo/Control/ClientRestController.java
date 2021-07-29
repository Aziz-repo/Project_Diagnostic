package com.example.demo.Control;

import java.util.List;

import com.example.demo.Service.ClientService;
import com.example.demo.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping(path="/admin/client")
public class ClientRestController {
    
    private final ClientService clientService;
    @Autowired
    public ClientRestController(ClientService clientService){
        this.clientService = clientService;
    }
    

    @GetMapping("/getclient") //Get
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Client> get_client(){
        System.out.println("Client sauvgardé");//testing purposes
        return clientService.get_client();
    }
    @DeleteMapping("/removeclient/{clientId}") //Delete
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void delete_client(@PathVariable("clientId") Long clientId){
        clientService.delete_client(clientId);
    }
    @PostMapping("/addclient") //Post
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void registerClient(@RequestBody Client client){
        clientService.addNewClient(client);
    }
    @PutMapping("/modifyclient/{clientId}") //Put
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void updateClient(@PathVariable("clientId") Long clientId,
                            @RequestParam(required = false) String nom,
                            @RequestParam(required = false) String prenom,
                            @RequestParam(required = false) Long cin,
                            @RequestParam(required = false) String voiture,
                            @RequestParam(required = false) String email,
                            @RequestParam(required = false) String password,
                            @RequestParam(required = false) String telephone){
        clientService.updateClient(clientId,nom,prenom,cin,voiture,email,password,telephone);
        
    

    }
   
}

    
    
    
   

    
    

