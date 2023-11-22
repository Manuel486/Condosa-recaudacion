package com.example.condosa_registrar_recaudacionbackend.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MntReciboRecaudacionDto {

    // Cuenta
    private Integer idCuenta;
    private String nombreCuenta;
    private String banco;
    private short idTipoMoneda;
    private String moneda;
    private BigInteger nroCuenta;
    private String nombre;
    private Integer idPersona;

    // CuentaPredio
    private Short idCuentaPredio;
    private String nombrePredio;
    private String dirrecion;
    private String tipoDePredio;
    private BigInteger nrCuentaPredio;
    private String tipoAutorizacion;
    private String estado;

    // Mantenimiento del recibo
    private Integer idMantRecibo;
    private String estadoRecibo;
    private BigDecimal importe;
}
