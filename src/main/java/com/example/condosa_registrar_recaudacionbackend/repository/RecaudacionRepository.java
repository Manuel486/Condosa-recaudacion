package com.example.condosa_registrar_recaudacionbackend.repository;

import com.example.condosa_registrar_recaudacionbackend.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RecaudacionRepository extends JpaRepository<Recaudacion, Integer> {
//    @Query("SELECT r.cuenta FROM Recaudacion r " +
//            "WHERE r.cuenta.persona.documento = :documento")
//    Cuenta findCuentaByPersonaDocumento(@Param("documento") String documento);
//
//    @Query("SELECT r.mantenimientoRecibo FROM Recaudacion r " +
//            "WHERE r.mantenimientoRecibo.recibo = :recibo")
//    MantenimientoRecibo findMantReciboByRecibo(@Param("recibo") String recibo);
//
//    @Query("SELECT r.cuentaPredio FROM Recaudacion r " +
//            "WHERE r.cuentaPredio.predio.ruc = :ruc")
//    CuentaPredio findPredioByRuc(@Param("ruc") String ruc);

}