package DigitalHouse.ClinicaOdontologica.controllers;

import DigitalHouse.ClinicaOdontologica.entity.Odontologo;
import DigitalHouse.ClinicaOdontologica.entity.Paciente;
import DigitalHouse.ClinicaOdontologica.exceptions.BadRequestException;
import DigitalHouse.ClinicaOdontologica.exceptions.ResourceNotFoundException;
import DigitalHouse.ClinicaOdontologica.service.OdontologoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
@AllArgsConstructor
@CrossOrigin("*")
public class OdontologoController {
    private final OdontologoService odontologoService;

    @PostMapping
    public ResponseEntity<Odontologo> save(@RequestBody Odontologo odontologo) throws BadRequestException {
        return new ResponseEntity<>(odontologoService.save(odontologo), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Odontologo>> getAll(){
        return new ResponseEntity<>(odontologoService.getAll(),HttpStatus.ACCEPTED);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<Odontologo> findById(@PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(odontologoService.findById(id),HttpStatus.FOUND);
    }

    @DeleteMapping
    public void deleteAll(){
        odontologoService.deleteAll();
    }

    @PutMapping
    public void update(@RequestBody Odontologo odontologo) throws BadRequestException {
        odontologoService.update(odontologo);
    }
}
