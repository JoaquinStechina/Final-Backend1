package DigitalHouse.ClinicaOdontologica.service;

import DigitalHouse.ClinicaOdontologica.entity.Domicilio;
import DigitalHouse.ClinicaOdontologica.exceptions.BadRequestException;
import DigitalHouse.ClinicaOdontologica.exceptions.ResourceNotFoundException;
import DigitalHouse.ClinicaOdontologica.repository.DomicilioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DomicilioService {
    private final DomicilioRepository domicilioRepository;

    public Domicilio save(Domicilio domicilio) throws BadRequestException {
        if(domicilio == null){
            throw new BadRequestException("El domicilio pasado es nulo");
        }
        else{
            return domicilioRepository.save(domicilio);
        }
    }
    public List<Domicilio> getAll(){
        return domicilioRepository.findAll();
    }
    public Domicilio findById(Long id) throws ResourceNotFoundException {
        return domicilioRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("No se ha encontrado el domicilio con el id "+id));
    }
    public void deleteAll(){
        domicilioRepository.deleteAll();
    }
    public void update(Domicilio domicilio) throws BadRequestException {
        if(domicilio == null){
            throw new BadRequestException("El domicilio pasado es nulo");
        }
        else{
            domicilioRepository.save(domicilio);
        }
    }
}
