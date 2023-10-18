package com.example.condosa_registrar_recaudacionbackend.repository;

import com.example.condosa_registrar_recaudacionbackend.model.MantenimientoRecibo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MantenimientoReciboRepository extends JpaRepository<MantenimientoRecibo,Integer> {

    MantenimientoRecibo findMantenimientoReciboByRecibo(String recibo);
}
