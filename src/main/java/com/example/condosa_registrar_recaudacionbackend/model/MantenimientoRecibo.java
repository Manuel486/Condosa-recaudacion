package com.example.condosa_registrar_recaudacionbackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity()
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mant_recibo")
public class MantenimientoRecibo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mant_recibo")
    private Integer idMantenimientoRecibo;

    @ManyToOne
    @JoinColumn(name = "id_casa", referencedColumnName = "id_casa")
    private Casa casa;

    @Column(name = "n_recibo", length = 8)
    @NotNull
    private String recibo;

    @Column(name = "periodo", length = 8)
    @NotNull
    private String periodo;

    @Column(name = "fecha_emision")
    @NotNull
    private Date fecha_emision;

    @Column(name = "fecha_vencimiento")
    @NotNull
    private Date fecha_vencimiento;

    @Column(name = "importe")
    private BigDecimal importe;

    @Column(name = "ajuste",precision = 6,scale = 2)
    private BigDecimal ajuste;

    @Column(name = "observacion", length = 100)
    private String observacion;

    @ManyToOne
    @JoinColumn(name = "id_recibo_estado", referencedColumnName = "id_recibo_estado")
    private ReciboEstado reciboEstado;
}
