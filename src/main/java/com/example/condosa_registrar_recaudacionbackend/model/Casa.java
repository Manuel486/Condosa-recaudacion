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
@Table(name = "casa")
public class Casa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_casa")
    private Integer idCasa;

    @ManyToOne
    @JoinColumn(name = "id_predio", referencedColumnName = "id_predio")
    private Predio predio;

    @ManyToOne
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "id_predio_mdu", referencedColumnName = "id_predio_mdu")
    private PredioMdu predioMdu;

    @Column(name = "numero")
    @NotNull
    private Short numero;

    @Column(name = "piso")
    private Short piso;

    @Column(name = "area")
    @NotNull
    private BigDecimal area;

    @Column(name = "participacion", precision = 6, scale = 2)
    private BigDecimal participacion;
}
