package com.example.demo.Control;

import com.example.demo.Service.Rendez_vousService;
import com.example.demo.model.Client;
import com.example.demo.model.Rendez_vous;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller(value = "rendez_vousController")
public class Rendez_vousController {
    
    private final Rendez_vousService rendez_vousService;
    private Rendez_vous rendez_vous;

    @Autowired
    public Rendez_vousController(Rendez_vousService rendez_vousService) {
        this.rendez_vousService = rendez_vousService;
    }
    public Rendez_vous getRendez_vous() {
        return rendez_vous;
    }
    public void setRendez_vous(Rendez_vous rendez_vous) {
        this.rendez_vous = rendez_vous;
    }
    //Backend Methods
    @PostMapping(value ="/rendez_vous")
    public String rendez_vous_page(@ModelAttribute("rendez_vous") Rendez_vous rendez_vous) {
        rendez_vousService.addNewRendezVous(rendez_vous); 
        return "accuiel2";
    } 
    @GetMapping(value = "/rendez_vous")
    public String reservation(Model model) {
        Client client = new Client();
        model.addAttribute("client", client);
        Rendez_vous rendez_vous = new Rendez_vous(client);
        model.addAttribute("rendez_vous", rendez_vous);
        return "rendez_vous";
    }



}
