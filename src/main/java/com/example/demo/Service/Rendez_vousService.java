package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import com.example.demo.Exeption.ApiRequestException;
import com.example.demo.Repository.Rendez_vousRepository;
import com.example.demo.model.Rendez_vous;
import java.util.Optional;


@Service
public class Rendez_vousService {
    private final Rendez_vousRepository rendez_vousRepository;

    @Autowired
    public Rendez_vousService(Rendez_vousRepository rendez_vousRepository, int nbrReservation){
            this.rendez_vousRepository = rendez_vousRepository;
    }
    public Optional<Rendez_vous> findById(Long id) {
        return rendez_vousRepository.findById(id);
    }
    public List<Rendez_vous>get_allRendezVous(){
        return rendez_vousRepository.findAll();
    }
    public void delete_RendezVoud(Long rendez_vousId){
        boolean exists = rendez_vousRepository.existsById(rendez_vousId);
        if(!exists){
            throw new ApiRequestException("Ce rendez-vous n'existe pas!!");
        }
        rendez_vousRepository.deleteById(rendez_vousId);
    }
    //reservation will not accure if the limite number of reservation is achieved
    public void addNewRendezVous(Rendez_vous rendez_vous){
        List<Rendez_vous> rendez_vousdate = rendez_vousRepository.findAll();
        if(rendez_vousdate.size() == rendez_vous.getnbrReservation()){
            throw new ApiRequestException("Full");
        }
        rendez_vousRepository.save(rendez_vous);
        
    }
    public void updatRendezVous(Long RendezVousId, String marque, String modele, String date, String nom, String telephone, String email){
        Rendez_vous rendez_vous = rendez_vousRepository.findById(RendezVousId).orElseThrow(()-> new ApiRequestException("Ce rendez_vous n'existe pas!!"));
        if(marque != null && !Objects.equals(marque,rendez_vous.getmarque()) && marque.length() > 0) {
            rendez_vous.setmarque(marque);
        }
        if(modele != null && !Objects.equals(modele,rendez_vous.getmodele()) && modele.length() > 0) {
            rendez_vous.setmodele(modele);
        }
        if(date != null && !Objects.equals(date,rendez_vous.getdate())){
            rendez_vous.setdate(date);
        }
        if(nom != null && !Objects.equals(nom, rendez_vous.getnom()) && nom.length() > 0) {
            rendez_vous.setnom(nom);
        }
        if(email != null && !Objects.equals(email, rendez_vous.getemail()) && nom.length() > 0) {
            rendez_vous.setemail(email);
        }
        if(telephone != null && !Objects.equals(telephone, rendez_vous.gettelephone()) && telephone.length() > 0) {
            rendez_vous.settelephone(telephone);
        }
    }
}
