package com.example.condosa_registrar_recaudacionbackend.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;

@AllArgsConstructor
@Setter
@Getter
public class RecaudacionRegistroDto {
    private Integer id_cuenta;
    private Integer id_mant_recibo;
    private BigInteger n_operacion;
    private Date fechaOperacion;
    private short id_tipo_moneda;
    private Double importe;
    private short id_recaudacion_estado;
    private short id_cuenta_predio;
    private String observacion;
}
