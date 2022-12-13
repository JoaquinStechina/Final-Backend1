package DigitalHouse.ClinicaOdontologica.controllers;

import DigitalHouse.ClinicaOdontologica.entity.Paciente;
import DigitalHouse.ClinicaOdontologica.exceptions.BadRequestException;
import DigitalHouse.ClinicaOdontologica.exceptions.ResourceNotFoundException;
import DigitalHouse.ClinicaOdontologica.service.PacienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
@AllArgsConstructor
@CrossOrigin("*")
public class PacienteController {
    private final PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Paciente> save(@RequestBody Paciente paciente) throws BadRequestException {
        return new ResponseEntity<>(pacienteService.save(paciente), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> getAll(){
        return new ResponseEntity<>(pacienteService.getAll(),HttpStatus.ACCEPTED);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<Paciente> findById(@PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(pacienteService.findById(id),HttpStatus.FOUND);
    }

    @DeleteMapping
    public void deleteAll(){
        pacienteService.deleteAll();
    }

    @PutMapping
    public void update(@RequestBody Paciente paciente) throws BadRequestException {
        pacienteService.update(paciente);
    }
}
