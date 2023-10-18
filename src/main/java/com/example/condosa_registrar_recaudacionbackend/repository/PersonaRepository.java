package com.example.condosa_registrar_recaudacionbackend.repository;

import com.example.condosa_registrar_recaudacionbackend.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona,Integer> {

    Persona findByDocumento(String documento);
}
