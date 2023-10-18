package com.example.condosa_registrar_recaudacionbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

@Entity()
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "recaudacion")
public class Recaudacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recaudacion")
    private Integer idRecaudacion;

    @ManyToOne
    @JoinColumn(name = "id_cuenta", referencedColumnName = "id_cuenta")
    private Cuenta cuenta;

    @ManyToOne
    @JoinColumn(name = "id_mant_recibo", referencedColumnName = "id_mant_recibo")
    private MantenimientoRecibo mantenimientoRecibo;

    @Column(name = "n_operacion")
    private BigInteger nOperacion;

    @Column(name = "fecha_operacion")
    private Date fechaOperacion;

    @ManyToOne
    @JoinColumn(name = "id_tipo_moneda", referencedColumnName = "id_tipo_moneda")
    private TipoMoneda tipoMoneda;

    @Column(name = "importe")
    private Double importe;

    @ManyToOne
    @JoinColumn(name = "id_recaudacion_estado", referencedColumnName = "id_recaudacion_estado")
    private RecaudacionEstado recaudacionEstado;

    @ManyToOne
    @JoinColumn(name = "id_cuenta_predio", referencedColumnName = "id_cuenta_predio")
    private CuentaPredio cuentaPredio;

    @Column(name = "observacion", length = 100)
    private String observacion;
}
