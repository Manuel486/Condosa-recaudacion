package com.example.condosa_registrar_recaudacionbackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity()
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "recaudacion_estado")
public class RecaudacionEstado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recaudacion_estado", columnDefinition = "smallint")
    private short idRecaudacionEstado;

    @Column(name = "descripcion", length = 15)
    @NotNull
    private String descripcion;
}
