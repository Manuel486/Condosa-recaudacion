package com.example.condosa_registrar_recaudacionbackend.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@AllArgsConstructor
@Setter
@Getter
public class CuentaPredioDto {

    private Short idCuentaPredio;
    private String nombre;
    private String dirrecion;
    private String tipoDePredio;
    private BigInteger nrCuentaPredio;
    private String tipoAutorizacion;
    private String estado;

    public CuentaPredioDto(){}
}
