package com.example.condosa_registrar_recaudacionbackend.repository;

import com.example.condosa_registrar_recaudacionbackend.model.Recaudacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecaudacionRepository extends JpaRepository<Recaudacion,Integer> {
}
