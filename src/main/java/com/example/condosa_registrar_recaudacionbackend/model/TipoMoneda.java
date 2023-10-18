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
@Table(name = "tipo_moneda")
public class TipoMoneda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_moneda", columnDefinition = "smallint")
    private short idTipoMoneda;

    @Column(name = "descripcion", length = 10)
    @NotNull
    private String descripcion;

    @Column(name = "etiqueta", length = 4)
    private String etiqueta;
}
