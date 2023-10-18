package com.example.condosa_registrar_recaudacionbackend.repository;

import com.example.condosa_registrar_recaudacionbackend.model.Cuenta;
import com.example.condosa_registrar_recaudacionbackend.model.CuentaPredio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaPredioRepository extends JpaRepository<CuentaPredio,Short> {

    CuentaPredio findByPredio_Ruc(String ruc);
}
