package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.example.demo.model.Rendez_vous;

public interface Rendez_vousRepository extends JpaRepository <Rendez_vous,Long> {
    
    List<Rendez_vous> findBydate(String date);
    List<Rendez_vous> findRendez_vousByEmailAndTelephone(String email,String telephone);
    
}
