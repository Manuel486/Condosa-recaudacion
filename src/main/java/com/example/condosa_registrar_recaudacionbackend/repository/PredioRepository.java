package com.example.condosa_registrar_recaudacionbackend.repository;

import com.example.condosa_registrar_recaudacionbackend.model.Predio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PredioRepository extends JpaRepository<Predio,Integer> {
}
