package com.example.demo.Rendez_vous;

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

import java.time.LocalDate;
import java.util.List;

import com.example.demo.Voiture.Voiture;

@RestController
@RequestMapping(path = "api/v1/FirstProject/rendez_vous")
public class Rendez_vousController{
    private final Rendez_vousService rendez_vousService;

    @Autowired
    public Rendez_vousController(Rendez_vousService rendez_vousService){
        this.rendez_vousService = rendez_vousService;
    }
    @GetMapping
    public List<Rendez_vous> get_allRendezVous(){
        return rendez_vousService.get_allRendezVous();
    }
    @DeleteMapping(path ="{rendez_vousId}")
    public void delete_RendezVoud(@PathVariable("rendez_vousId") Long rendezvousId){
        rendez_vousService.delete_RendezVoud(rendezvousId);
    }
    @PostMapping
    public void addNewRendezVous(@RequestBody Rendez_vous rendez_vous){
        rendez_vousService.addNewRendezVous(rendez_vous);
    }
    @PutMapping(path = "{rendez_vousId}")
        public void updatRendezVous(@PathVariable("rendez_vousId") Long rendez_vousId,
                                    @RequestParam(required = false) Voiture voiture,
                                    @RequestParam(required = false) LocalDate date){
            rendez_vousService.updatRendezVous(rendez_vousId, voiture, date);
                
    }

}