package com.backend.clinicaodontologica.controller;

import com.backend.clinicaodontologica.dto.entrada.turno.TurnoEntradaDto;
import com.backend.clinicaodontologica.dto.modificacion.TurnoModificacionEntradaDto;
import com.backend.clinicaodontologica.dto.salida.turno.TurnoSalidaDto;
import com.backend.clinicaodontologica.exceptions.BadRequestException;
import com.backend.clinicaodontologica.exceptions.ResourcesNotFoundException;
import com.backend.clinicaodontologica.service.ITurnoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/turnos")
@CrossOrigin
public class TurnoController {
private ITurnoService iTurnoService;

    public TurnoController(ITurnoService iTurnoService) {
        this.iTurnoService = iTurnoService;
    }
    @PostMapping("registrar")
    public ResponseEntity<TurnoSalidaDto> registrarTurno(@Valid @RequestBody TurnoEntradaDto turnoEntradaDto) throws BadRequestException{
        return new ResponseEntity<>(iTurnoService.registrarTurno(turnoEntradaDto),
                HttpStatus.CREATED);
    }

     @GetMapping("listar")
    public ResponseEntity<List<TurnoSalidaDto>> obtenerTurnoPorId(){
        return new ResponseEntity<>(iTurnoService.listarTurnos(),HttpStatus.OK);

     }

     @PutMapping("actualizar")
    public ResponseEntity<TurnoSalidaDto> actualizarTurno(@Valid @RequestBody TurnoModificacionEntradaDto turnoModificacionEntradaDto) throws ResourcesNotFoundException{
        return new ResponseEntity<>(iTurnoService.modificarturno(turnoModificacionEntradaDto),HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<TurnoSalidaDto> obtenerTurnoPorID(@PathVariable Long id){
        return  new ResponseEntity<>(iTurnoService.buscarturnoporid(id),HttpStatus.OK);

    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<?> eliminarTurno(@PathVariable Long id)throws ResourcesNotFoundException{
        iTurnoService.eliminarturno(id);
       return new ResponseEntity<>("Turno eliminado correctamente",HttpStatus.OK);

    }


    }

