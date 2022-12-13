package DigitalHouse.ClinicaOdontologica.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Domicilio")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String calle;

    @Column
    private String localidad;

    @Column
    private String provincia;
}
