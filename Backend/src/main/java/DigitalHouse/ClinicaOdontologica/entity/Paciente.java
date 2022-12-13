package DigitalHouse.ClinicaOdontologica.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Paciente")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private String dni;

    @Column
    private LocalDateTime fecha_alta;

    @OneToOne
    @JoinColumn(name = "domicilio_id",referencedColumnName = "id")
    private Domicilio domicilio;

    @OneToMany
    @JsonBackReference
    private List<Turno> turnos;
}
