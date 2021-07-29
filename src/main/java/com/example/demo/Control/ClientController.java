package com.example.demo.Control;




import com.example.demo.Service.ClientService;
import com.example.demo.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;





@Controller(value= "clientController")
public class ClientController {


    private final ClientService clientService;
   
    private String login;
    private String password;
    private int cin;
    private int telephone;
    private Client client = new Client();
    private boolean loggedIn = false;
    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    //getters
    public String getemail(){return this.login;}
    public String getPassword(){return this.password;}
    public Client getClient(){return this.client;}
    public boolean getLoggedIn(){return this.loggedIn;}
    public int getcin() {return this.cin;}
    public int gettelephone() {return this.telephone;}
    //setters
    public void setemail(String login){this.login = login;}
    public void setpassword(String password){this.password = password;}
    public void setClient(Client client) {this.client = client;}
    public void setLoggedIn(boolean loggedIn) {this.loggedIn = loggedIn;}
    public void setcin(int cin) {this.cin = cin;}
    public void settelephone(int telephone) {this.telephone = telephone;}
    //Back-end Methodes
   
    @GetMapping(value = "/signin")
    public String signinPage(Model model) {
        model.addAttribute("client", client);
        return "sign_in";
        
    }
    
    @PostMapping(value = "/signin")
    public String signin(@ModelAttribute("client") Client client) {
        if(clientService.authenticate(client.getEmail(), client.getpassword())) {
            loggedIn = true;
            this.client = client;
            return "accuiel2";
        }
        return "ERROR";
    }
    
    @GetMapping(value = "/signup")
    public String signup(Model model) {
        model.addAttribute("client", client);
        return "sign_up";
    }
    /**
     * back end function to signing up in the webapp
     * @return
     */
    @PostMapping(value ="/signup")
    public String doSignUp(@ModelAttribute("client") Client client) {
       clientService.addNewClient(client);
       this.client = client;
       loggedIn = true;
       return "accuiel2";
        
    } 
    @GetMapping("/contact")
    public String contact(Model model) {
        return "contact";
    }
    @RequestMapping({"/", "/accuiel"}) 
    public String home() {
        if (loggedIn) {
            return "accuiel2";
        }
        return "accuiel";
    } 
    @RequestMapping(value = "/log_out")
    public String doLogout() {
        loggedIn = false;
        return "redirect:/";
    }  
    @GetMapping(value = "/profile")
    public String profile(Model model) {
        model.addAttribute("client", this.client);
        return "profile";

    }
  
    
    
    
    
   
    
 
    
}


    


