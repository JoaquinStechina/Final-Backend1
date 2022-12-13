package DigitalHouse.ClinicaOdontologica.service;

import DigitalHouse.ClinicaOdontologica.entity.Domicilio;
import DigitalHouse.ClinicaOdontologica.exceptions.BadRequestException;
import DigitalHouse.ClinicaOdontologica.exceptions.ResourceNotFoundException;
import DigitalHouse.ClinicaOdontologica.repository.DomicilioRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DomicilioServiceTest {

    @Mock
    private DomicilioRepository domicilioRepository;
    @InjectMocks
    private DomicilioService domicilioService;

    @Test
    @DisplayName("Save domicilio method")
    void save() throws BadRequestException {
        //GIVEN
        var aux1 = new Domicilio(1L,"Siempre viva","Springfield","Idaho");

        //WHEN
        when(domicilioRepository.save(aux1)).thenReturn(aux1);
        var DomicilioGuardado = domicilioService.save(aux1);

        //THEN
        verify(domicilioRepository,times(1)).save(aux1);
        assertEquals(DomicilioGuardado,aux1);
        assertThrows(BadRequestException.class,()->domicilioService.save(null));
    }

    @Test
    @DisplayName("Get all domicilios method")
    void getAll(){
        //GIVEN
        List<Domicilio> Domicilios = new ArrayList<>();
        var aux1 = new Domicilio(1L,"Siempre viva","Springfield","Idaho");
        var aux2 = new Domicilio(2L,"6969","Lejos","de tu alcance");
        var aux3 = new Domicilio(3L,"420","tercermundo","America");

        Domicilios.add(aux1);
        Domicilios.add(aux2);
        Domicilios.add(aux3);

        //WHEN
        when(domicilioRepository.findAll()).thenReturn(Domicilios);
        List<Domicilio> listaDomicilios = domicilioService.getAll();

        //THEN
        assertEquals(3,listaDomicilios.size());
        verify(domicilioRepository,times(1)).findAll();
    }

    @Test
    @DisplayName("Find a domicilio by ID method")
    void findById() throws ResourceNotFoundException {
        //GIVEN
        var DomicilioToFind = new Domicilio(1L,"Siempre viva","Springfield","Idaho");

        //WHEN
        when(domicilioRepository.findById(1L)).thenReturn(Optional.of(DomicilioToFind));
        var domicilioFound = domicilioService.findById(1L);

        //THEN
        verify(domicilioRepository,times(1)).findById(1L);
        assertEquals(DomicilioToFind,domicilioFound);
    }

    @Test
    @DisplayName("Delete all domicilios method")
    void deleteAll(){
        //WHEN
        domicilioService.deleteAll();

        //THEN
        verify(domicilioRepository,times(1)).deleteAll();
    }

    @Test
    @DisplayName("Update domicilio method")
    void update() throws BadRequestException {
        //GIVEN
        var DomicilioUpdated = new Domicilio(1L,"Siempre viva","Springfield","Idaho");

        //WHEN
        domicilioService.update(DomicilioUpdated);

        //THEN
        verify(domicilioRepository,times(1)).save(DomicilioUpdated);
        assertThrows(BadRequestException.class,()->domicilioService.update(null));
    }
}