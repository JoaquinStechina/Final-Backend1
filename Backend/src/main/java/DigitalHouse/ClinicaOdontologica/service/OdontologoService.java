package DigitalHouse.ClinicaOdontologica.service;

import DigitalHouse.ClinicaOdontologica.entity.Odontologo;
import DigitalHouse.ClinicaOdontologica.exceptions.BadRequestException;
import DigitalHouse.ClinicaOdontologica.exceptions.ResourceNotFoundException;
import DigitalHouse.ClinicaOdontologica.repository.OdontologoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OdontologoService {
    private final OdontologoRepository odontologoRepository;

    public Odontologo save(Odontologo odontologo) throws BadRequestException {
        if(odontologo == null){
            throw new BadRequestException("El odontologo pasado es nulo");
        }
        return odontologoRepository.save(odontologo);
    }
    public List<Odontologo> getAll(){
        return odontologoRepository.findAll();
    }
    public Odontologo findById(Long id) throws ResourceNotFoundException {
        return odontologoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("No se ha encontrado el odontologo con el id "+id));
    }
    public void deleteAll(){
        odontologoRepository.deleteAll();
    }
    public void update(Odontologo odontologo) throws BadRequestException {
        if(odontologo == null){
            throw new BadRequestException("El odontologo pasado es nulo");
        }
        odontologoRepository.save(odontologo);
    }
}
