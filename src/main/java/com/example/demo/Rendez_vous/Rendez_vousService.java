package com.example.demo.Rendez_vous;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import com.example.demo.Voiture.Voiture;

public class Rendez_vousService {
    private final Rendez_vousRepository rendez_vousRepository;

    @Autowired
    public Rendez_vousService(Rendez_vousRepository rendez_vousRepository){
            this.rendez_vousRepository = rendez_vousRepository;
    }
    public List<Rendez_vous>get_allRendezVous(){
        return rendez_vousRepository.findAll();
    }
    public void delete_RendezVoud(Long rendez_vousId){
        boolean exists = rendez_vousRepository.existsById(rendez_vousId);
        if(!exists){
            throw new IllegalStateException("Ce rendez-vous n'existe pas!!");
        }
        rendez_vousRepository.deleteById(rendez_vousId);
    }
    public void addNewRendezVous(Rendez_vous rendez_vous){
        List<Rendez_vous> rendez_vousdate = rendez_vousRepository.findBydate(rendez_vous.getdate());
        if(!rendez_vousdate.isEmpty()){
            throw new IllegalStateException("déja reservé");
        }
        rendez_vousRepository.save(rendez_vous);
    }
    public void updatRendezVous(Long RendezVousId, Voiture voiture, LocalDate date){
        Rendez_vous rendez_vous = rendez_vousRepository.findById(RendezVousId).orElseThrow(()-> new IllegalStateException("Ce rendez_vous n'existe pas!!"));
        if(voiture != null && voiture.equals(rendez_vous.getvoiture())){
            rendez_vous.setvoiture(voiture);
        }
        if(date != null && !Objects.equals(date,rendez_vous.getdate())){
            rendez_vous.setdate(date);
        }
    }
}
