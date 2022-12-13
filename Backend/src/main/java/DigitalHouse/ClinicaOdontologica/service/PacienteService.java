package DigitalHouse.ClinicaOdontologica.service;

import DigitalHouse.ClinicaOdontologica.entity.Paciente;
import DigitalHouse.ClinicaOdontologica.exceptions.BadRequestException;
import DigitalHouse.ClinicaOdontologica.exceptions.ResourceNotFoundException;
import DigitalHouse.ClinicaOdontologica.repository.PacienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PacienteService {
    private final PacienteRepository pacienteRepository;

    public Paciente save(Paciente paciente) throws BadRequestException {
        if(paciente == null){
            throw new BadRequestException("El paciente pasado es nulo");
        }
        return pacienteRepository.save(paciente);
    }
    public List<Paciente> getAll(){
        return pacienteRepository.findAll();
    }
    public Paciente findById(Long id) throws ResourceNotFoundException {
        return pacienteRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No se ha encontrado el paciente con el id "+id));
    }
    public void deleteAll(){
        pacienteRepository.deleteAll();
    }
    public void update(Paciente paciente) throws BadRequestException {
        if(paciente == null){
            throw new BadRequestException("El paciente pasado es nulo");
        }
        pacienteRepository.save(paciente);
    }
}
