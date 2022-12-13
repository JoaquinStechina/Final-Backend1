package DigitalHouse.ClinicaOdontologica.controllers;

import DigitalHouse.ClinicaOdontologica.entity.Domicilio;
import DigitalHouse.ClinicaOdontologica.exceptions.BadRequestException;
import DigitalHouse.ClinicaOdontologica.exceptions.ResourceNotFoundException;
import DigitalHouse.ClinicaOdontologica.service.DomicilioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/domicilios")
@AllArgsConstructor
@CrossOrigin("*")
public class DomicilioController {
    private final DomicilioService domicilioService;

    @PostMapping
    public ResponseEntity<Domicilio> save(@RequestBody Domicilio domicilio) throws BadRequestException {
        return new ResponseEntity<>(domicilioService.save(domicilio), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Domicilio>> getAll(){
        return new ResponseEntity<>(domicilioService.getAll(),HttpStatus.ACCEPTED);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<Domicilio> findById(@PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(domicilioService.findById(id),HttpStatus.FOUND);
    }

    @DeleteMapping
    public void deleteAll(){
        domicilioService.deleteAll();
    }

    @PutMapping
    public void update(@RequestBody Domicilio domicilio) throws BadRequestException {
        domicilioService.update(domicilio);
    }
}
