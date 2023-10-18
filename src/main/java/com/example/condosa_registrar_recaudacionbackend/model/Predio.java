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
@Table(name = "predio")
public class Predio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_predio")
    private Integer idPredio;

    @ManyToOne
    @JoinColumn(name = "id_tipo_predio", referencedColumnName = "id_tipo_predio")
    private TipoPredio tipoPredio;

    @Column(name = "descripcion", length = 80)
    private String descripcion;

    @Column(name = "ruc", length = 20)
    private String ruc;

    @Column(name = "telefono", length = 12)
    private String telefono;

    @Column(name = "correo", length = 80)
    private String correo;

    @Column(name = "direccion", length = 100)
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "idubigeo", referencedColumnName = "idubigeo")
    private Ubigeo ubigeo;

    @ManyToOne
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    private Persona persona;

    @Column(name = "url_imagen", length = 120)
    private String urlImagen;
}
