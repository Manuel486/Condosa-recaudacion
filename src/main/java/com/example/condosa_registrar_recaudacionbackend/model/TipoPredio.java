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
@Table(name = "tipo_predio")
public class TipoPredio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_predio")
    private Integer idTipoPredio;

    @Column(name = "nomre_predio")
    private String nombrePredio;
}
