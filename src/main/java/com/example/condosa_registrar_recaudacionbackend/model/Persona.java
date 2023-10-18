package com.example.condosa_registrar_recaudacionbackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity()
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Integer idPersona;

    @Column(name = "apellido_paterno", length = 60)
    @NotNull
    private String apellidoPaterno;

    @Column(name = "apellido_materno", length = 60)
    @NotNull
    private String apellidoMaterno;

    @Column(name = "nombres", length = 60)
    @NotNull
    private String nombres;

    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @ManyToOne
    @JoinColumn(name = "id_tipo_documento", referencedColumnName = "id_tipo_documento")
    private TipoDocumento tipoDocumento;

    @Column(name = "ndocumento", length = 15)
    private String documento;

    @Column(name = "direccion", length = 150)
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "idubigeo", referencedColumnName = "idubigeo")
    private Ubigeo ubigeo;

}
