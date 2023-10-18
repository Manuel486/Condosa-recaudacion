package com.example.condosa_registrar_recaudacionbackend.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;

@AllArgsConstructor
@Setter
@Getter
public class RecaudacionDto {
    private int idRecaudacion;
    private BigInteger nOperacion;
    private String fechaOperacion;
    private String nombre;
    private String predio;
    private Double importe;
    private String estado;

    public RecaudacionDto(){}
}
