package DigitalHouse.ClinicaOdontologica.service;

import DigitalHouse.ClinicaOdontologica.entity.Turno;
import DigitalHouse.ClinicaOdontologica.exceptions.BadRequestException;
import DigitalHouse.ClinicaOdontologica.exceptions.ResourceNotFoundException;
import DigitalHouse.ClinicaOdontologica.repository.TurnoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TurnoService {
    private final TurnoRepository turnoRepository;

    public Turno save(Turno turno) throws BadRequestException {
        if(turno == null){
            throw new BadRequestException("El turno pasado es nulo");
        }
        return turnoRepository.save(turno);
    }
    public List<Turno> getAll(){
        return turnoRepository.findAll();
    }
    public Turno findById(Long id) throws ResourceNotFoundException {
        return turnoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("El turno con el id "+id+" no se ha encontrado"));
    }
    public void deleteAll(){
        turnoRepository.deleteAll();
    }
    public void update(Turno turno) throws BadRequestException {
        if(turno == null){
            throw new BadRequestException("El turno pasado es nulo");
        }
        turnoRepository.save(turno);
    }
}
