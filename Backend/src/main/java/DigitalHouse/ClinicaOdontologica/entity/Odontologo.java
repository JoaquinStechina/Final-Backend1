package DigitalHouse.ClinicaOdontologica.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Odontologo")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Odontologo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String matricula;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @OneToMany
    @JsonBackReference
    private List<Turno> turnos;
}
