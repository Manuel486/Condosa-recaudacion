package com.example.condosa_registrar_recaudacionbackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Date;

@Entity()
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cuenta_predio")
public class CuentaPredio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cuenta_predio", columnDefinition = "smallint")
    private short idCuentaPredio;

    @ManyToOne
    @JoinColumn(name = "id_predio", referencedColumnName = "id_predio")
    private Predio predio;

    @ManyToOne
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "id_tipo_autorizacion", referencedColumnName = "id_tipo_autorizacion")
    private TipoAutorizacion tipoAutorizacion;

    @ManyToOne
    @JoinColumn(name = "id_banco", referencedColumnName = "id_banco")
    private Banco banco;

    @ManyToOne
    @JoinColumn(name = "id_tipo_moneda", referencedColumnName = "id_tipo_moneda")
    private TipoMoneda tipoMoneda;

    @Column(name = "ncuenta")
    @NotNull
    private BigInteger nCuenta;

    @Column(name = "ntarjeta")
    private BigInteger nTarjeta;

    @Column(name = "fecha_apertura")
    @NotNull
    private Date fechaApertura;

    @Column(name = "fecha_autorizacion")
    private Date fechaAutorizacion;

    @Column(name = "fecha_cierre")
    private Date fechaCierre;

    @Column(name = "correo_autorizado",length = 40)
    private String correoAutorizado;
}
