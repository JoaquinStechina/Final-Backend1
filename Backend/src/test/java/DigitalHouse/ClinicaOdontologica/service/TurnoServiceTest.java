package DigitalHouse.ClinicaOdontologica.service;

import DigitalHouse.ClinicaOdontologica.entity.Turno;
import DigitalHouse.ClinicaOdontologica.exceptions.BadRequestException;
import DigitalHouse.ClinicaOdontologica.exceptions.ResourceNotFoundException;
import DigitalHouse.ClinicaOdontologica.repository.TurnoRepository;
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
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TurnoServiceTest {

    @Mock
    private TurnoRepository turnoRepository;
    @InjectMocks
    private TurnoService turnoService;

    @Test
    @DisplayName("Save turno method")
    void save() throws BadRequestException{
        //GIVEN
        var aux1 = new Turno(1L,LocalDateTime.now(),null,null);

        //WHEN
        when(turnoRepository.save(aux1)).thenReturn(aux1);
        var turnoGuardado = turnoService.save(aux1);

        //THEN
        verify(turnoRepository,times(1)).save(aux1);
        assertEquals(turnoGuardado,aux1);
        assertThrows(BadRequestException.class,()->turnoService.save(null));
    }

    @Test
    @DisplayName("Get all turnos method")
    void getAll(){
        //GIVEN
        List<Turno> turnos = new ArrayList<>();
        Turno aux1 = new Turno(1L,LocalDateTime.now(),null,null);
        Turno aux2 = new Turno(2L,LocalDateTime.now(),null,null);
        Turno aux3 = new Turno(3L,LocalDateTime.now(),null,null);

        turnos.add(aux1);
        turnos.add(aux2);
        turnos.add(aux3);

        //WHEN
        when(turnoRepository.findAll()).thenReturn(turnos);
        List<Turno> listaTurnos = turnoService.getAll();

        //THEN
        assertEquals(3,listaTurnos.size());
        verify(turnoRepository,times(1)).findAll();
    }

    @Test
    @DisplayName("Find a turno by ID method")
    void findById() throws ResourceNotFoundException{
        //GIVEN
        var turnoToFind = new Turno(4L,LocalDateTime.now(),null,null);

        //WHEN
        when(turnoRepository.findById(4L)).thenReturn(Optional.of(turnoToFind));
        var turnoFound = turnoService.findById(4L);

        //THEN
        verify(turnoRepository,times(1)).findById(4L);
        assertEquals(turnoToFind,turnoFound);
    }

    @Test
    @DisplayName("Delete all turnos method")
    void deleteAll(){
        //WHEN
        turnoService.deleteAll();

        //THEN
        verify(turnoRepository,times(1)).deleteAll();
    }

    @Test
    @DisplayName("Update turno method")
    void update() throws BadRequestException {
        //GIVEN
        var turnoUpdated = new Turno(2L,LocalDateTime.now(),null,null);

        //WHEN
        turnoService.update(turnoUpdated);

        //THEN
        verify(turnoRepository,times(1)).save(turnoUpdated);
        assertThrows(BadRequestException.class,()->turnoService.update(null));
    }
}