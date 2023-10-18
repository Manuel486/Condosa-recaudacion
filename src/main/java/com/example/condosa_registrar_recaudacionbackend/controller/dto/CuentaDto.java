package com.example.condosa_registrar_recaudacionbackend.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@AllArgsConstructor
@Setter
@Getter
public class CuentaDto {

    private Integer idCuenta;
    private String nombre;
    private String banco;
    private String moneda;
    private BigInteger nroCuenta;

    public CuentaDto(){}
}
