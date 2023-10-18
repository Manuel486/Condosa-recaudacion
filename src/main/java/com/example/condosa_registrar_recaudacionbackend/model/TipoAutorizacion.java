package com.example.condosa_registrar_recaudacionbackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity()
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tipo_autorizacion")
public class TipoAutorizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_autorizacion", columnDefinition = "smallint")
    private short idTipoAutorizacion;

    @Column(name = "descripcion", length = 30)
    @NotNull
    private String descripcion;
}
