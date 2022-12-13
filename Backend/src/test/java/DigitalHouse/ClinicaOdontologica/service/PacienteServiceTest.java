package DigitalHouse.ClinicaOdontologica.service;

import DigitalHouse.ClinicaOdontologica.entity.Paciente;
import DigitalHouse.ClinicaOdontologica.exceptions.BadRequestException;
import DigitalHouse.ClinicaOdontologica.exceptions.ResourceNotFoundException;
import DigitalHouse.ClinicaOdontologica.repository.PacienteRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PacienteServiceTest {

    @Mock
    private PacienteRepository pacienteRepository;
    @InjectMocks
    private PacienteService pacienteService;

    @Test
    @DisplayName("Save paciente method")
    void save() throws BadRequestException {
        //GIVEN
        var aux1 = new Paciente(1L,"Juan","Perez","123456",LocalDateTime.now(),null,null);

        //WHEN
        when(pacienteRepository.save(aux1)).thenReturn(aux1);
        var turnoGuardado = pacienteService.save(aux1);

        //THEN
        verify(pacienteRepository,times(1)).save(aux1);
        assertEquals(turnoGuardado,aux1);
        assertThrows(BadRequestException.class,()->pacienteService.save(null));
    }

    @Test
    @DisplayName("Get all pacientes method")
    void getAll(){
        //GIVEN
        List<Paciente> pacientes = new ArrayList<>();
        var aux1 = new Paciente(1L,"Franco","Cipres","42069",LocalDateTime.now(),null,null);
        var aux2 = new Paciente(2L,"Joaquin","Stechina","123456",LocalDateTime.now(),null,null);
        var aux3 = new Paciente(3L,"Maximiliano","Franzoi","010101",LocalDateTime.now(),null,null);

        pacientes.add(aux1);
        pacientes.add(aux2);
        pacientes.add(aux3);

        //WHEN
        when(pacienteRepository.findAll()).thenReturn(pacientes);
        List<Paciente> listaPacientes = pacienteService.getAll();

        //THEN
        assertEquals(3,listaPacientes.size());
        verify(pacienteRepository,times(1)).findAll();
    }

    @Test
    @DisplayName("Find a paciente by ID method")
    void findById() throws ResourceNotFoundException {
        //GIVEN
        var pacienteToFind = new Paciente(1L,"Juan","Perez","123456",LocalDateTime.now(),null,null);

        //WHEN
        when(pacienteRepository.findById(1L)).thenReturn(Optional.of(pacienteToFind));
        var pacienteFound = pacienteService.findById(1L);

        //THEN
        verify(pacienteRepository,times(1)).findById(1L);
        assertEquals(pacienteToFind,pacienteFound);
    }

    @Test
    @DisplayName("Delete all pacientes method")
    void deleteAll(){
        //WHEN
        pacienteService.deleteAll();

        //THEN
        verify(pacienteRepository,times(1)).deleteAll();
    }

    @Test
    @DisplayName("Update paciente method")
    void update() throws BadRequestException {
        //GIVEN
        var pacienteUpdated = new Paciente(1L,"Juan","Perez","123456",LocalDateTime.now(),null,null);

        //WHEN
        pacienteService.update(pacienteUpdated);

        //THEN
        verify(pacienteRepository,times(1)).save(pacienteUpdated);
        assertThrows(BadRequestException.class,()->pacienteService.update(null));
    }
}