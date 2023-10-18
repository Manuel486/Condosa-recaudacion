package com.example.condosa_registrar_recaudacionbackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity()
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ubigeo")
public class Ubigeo {

    @Id
    @Column(name = "idubigeo", length = 6)
    private String idUbigeo;

    @Column(name = "departamento", length = 60)
    private String departamento;

    @Column(name = "provincia", length = 60)
    private String provincia;

    @Column(name = "distrito", length = 60)
    private String distrito;

    @Column(name = "superficie", precision = 10, scale = 4)
    private BigDecimal superficie;

    @Column(name = "altitud", precision = 10, scale = 4)
    private BigDecimal altitud;

    @Column(name = "latitud", precision = 10, scale = 4)
    private BigDecimal latitud;

    @Column(name = "longitud", precision = 10, scale = 4)
    private BigDecimal longitud;
}
