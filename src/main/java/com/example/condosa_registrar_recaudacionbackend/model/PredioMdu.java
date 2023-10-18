package com.example.condosa_registrar_recaudacionbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity()
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "predio_mdu")
public class PredioMdu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_predio_mdu")
    private Integer idPredioMdu;

    @ManyToOne
    @JoinColumn(name = "id_predio", referencedColumnName = "id_predio")
    private Predio predio;

    @ManyToOne
    @JoinColumn(name = "id_mdu", referencedColumnName = "id_mdu")
    private Mdu mdu;

    @Column(name = "descripcion", length = 4)
    private String descripcion;

    @Column(name = "direccion", length = 10)
    private Character direccion;

    @Column(name = "numero", length = 10)
    private String numero;
}
