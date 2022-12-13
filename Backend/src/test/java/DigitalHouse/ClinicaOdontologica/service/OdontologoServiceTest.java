package DigitalHouse.ClinicaOdontologica.service;

import DigitalHouse.ClinicaOdontologica.entity.Odontologo;
import DigitalHouse.ClinicaOdontologica.exceptions.BadRequestException;
import DigitalHouse.ClinicaOdontologica.exceptions.ResourceNotFoundException;
import DigitalHouse.ClinicaOdontologica.repository.OdontologoRepository;
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
class OdontologoServiceTest {

    @Mock
    private OdontologoRepository odontologoRepository;
    @InjectMocks
    private OdontologoService odontologoService;

    @Test
    @DisplayName("Save odontologo method")
    void save() throws BadRequestException {
        //GIVEN
        var aux1 = new Odontologo(1L,"abcd1234","Enzo","Fernandez",null);

        //WHEN
        when(odontologoRepository.save(aux1)).thenReturn(aux1);
        var odontologoGuardado = odontologoService.save(aux1);

        //THEN
        verify(odontologoRepository,times(1)).save(aux1);
        assertEquals(odontologoGuardado,aux1);
        assertThrows(BadRequestException.class,()->odontologoService.save(null));
    }

    @Test
    @DisplayName("Get all odontologos method")
    void getAll(){
        //GIVEN
        List<Odontologo> odontologos = new ArrayList<>();
        var aux1 = new Odontologo(1L,"abcd1234","Enzo","Fernandez",null);
        var aux2 = new Odontologo(2L,"abcd1234","Julian","Alvarez",null);
        var aux3 = new Odontologo(3L,"abcd1234","NoMeAcuerdo","Otamendi",null);

        odontologos.add(aux1);
        odontologos.add(aux2);
        odontologos.add(aux3);

        //WHEN
        when(odontologoRepository.findAll()).thenReturn(odontologos);
        List<Odontologo> listaOdontologos = odontologoService.getAll();

        //THEN
        assertEquals(3,listaOdontologos.size());
        verify(odontologoRepository,times(1)).findAll();
    }

    @Test
    @DisplayName("Find a odontologo by ID method")
    void findById() throws ResourceNotFoundException {
        //GIVEN
        var odontologoToFind = new Odontologo(1L,"abcd1234","Enzo","Fernandez",null);

        //WHEN
        when(odontologoRepository.findById(1L)).thenReturn(Optional.of(odontologoToFind));
        var odontologoFound = odontologoService.findById(1L);

        //THEN
        verify(odontologoRepository,times(1)).findById(1L);
        assertEquals(odontologoToFind,odontologoFound);
    }

    @Test
    @DisplayName("Delete all odontologos method")
    void deleteAll(){
        //WHEN
        odontologoService.deleteAll();

        //THEN
        verify(odontologoRepository,times(1)).deleteAll();
    }

    @Test
    @DisplayName("Update odontologo method")
    void update() throws BadRequestException {
        //GIVEN
        var odontologoUpdated = new Odontologo(1L,"abcd1234","Enzo","Fernandez",null);

        //WHEN
        odontologoService.update(odontologoUpdated);

        //THEN
        verify(odontologoRepository,times(1)).save(odontologoUpdated);
        assertThrows(BadRequestException.class,()->odontologoService.update(null));
    }
}