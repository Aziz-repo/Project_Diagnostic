package com.example.demo.Rendez_vous;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface Rendez_vousRepository extends JpaRepository <Rendez_vous,Long> {
    
    List<Rendez_vous> findBydate(LocalDate date);
    
}
