package DigitalHouse.ClinicaOdontologica.controllers;

import DigitalHouse.ClinicaOdontologica.entity.Turno;
import DigitalHouse.ClinicaOdontologica.exceptions.BadRequestException;
import DigitalHouse.ClinicaOdontologica.exceptions.ResourceNotFoundException;
import DigitalHouse.ClinicaOdontologica.service.TurnoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
@AllArgsConstructor
@CrossOrigin("*")
public class TurnoController {
    private final TurnoService turnoService;
    
    @PostMapping
    public ResponseEntity<Turno> save(@RequestBody Turno turno) throws BadRequestException {
        return new ResponseEntity<>(turnoService.save(turno), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Turno>> getAll(){
        return new ResponseEntity<>(turnoService.getAll(),HttpStatus.ACCEPTED);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<Turno> findById(@PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(turnoService.findById(id),HttpStatus.FOUND);
    }

    @DeleteMapping
    public void deleteAll(){
        turnoService.deleteAll();
    }

    @PutMapping
    public void update(@RequestBody Turno turno) throws BadRequestException {
        turnoService.update(turno);
    }
}
