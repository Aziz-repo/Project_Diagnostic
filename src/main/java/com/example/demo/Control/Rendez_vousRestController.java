package com.example.demo.Control;

import java.util.List;

import com.example.demo.Service.Rendez_vousService;
import com.example.demo.model.Rendez_vous;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/admin/rendez_vous")
public class Rendez_vousRestController{
    private final Rendez_vousService rendez_vousService;

    @Autowired
    public Rendez_vousRestController(Rendez_vousService rendez_vousService){
        this.rendez_vousService = rendez_vousService;
    }
    @GetMapping(path = "/getrendez_vous")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Rendez_vous> get_allRendezVous(){
        return rendez_vousService.get_allRendezVous();
    }
    @DeleteMapping(path ="{rendez_vousId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void delete_RendezVoud(@PathVariable("rendez_vousId") Long rendezvousId){
        rendez_vousService.delete_RendezVoud(rendezvousId);
    }
    @PostMapping(path = "/addrendez_vous")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void addNewRendezVous(@RequestBody Rendez_vous rendez_vous){
        rendez_vousService.addNewRendezVous(rendez_vous);
    }
    @PutMapping(path = "{rendez_vousId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
        public void updatRendezVous(@PathVariable("rendez_vousId") Long rendez_vousId,
                                    @RequestParam(required = false) String marque,
                                    @RequestParam(required = false) String modele,
                                    @RequestParam(required = false) String date){
            rendez_vousService.updatRendezVous(rendez_vousId,marque,modele, date);
                
    }

}