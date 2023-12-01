package com.backend.clinicaodontologica.controller;

import com.backend.clinicaodontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.backend.clinicaodontologica.dto.modificacion.PacienteModificacionEntradaDto;
import com.backend.clinicaodontologica.dto.salida.paciente.PacienteSalidaDto;
import com.backend.clinicaodontologica.exceptions.ResourcesNotFoundException;
import com.backend.clinicaodontologica.service.IPacienteService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin
public class PacienteController {
    private final  IPacienteService iPacienteService;

    public PacienteController(IPacienteService iPacienteService) {
        this.iPacienteService = iPacienteService;
    }

    @PostMapping("registrar")
    public ResponseEntity<PacienteSalidaDto> registrarPaciente(@RequestBody @Valid PacienteEntradaDto paciente){
        return new ResponseEntity<>(iPacienteService.registrarPaciente(paciente), HttpStatus.CREATED);
    }




    @GetMapping("{id}")
    public ResponseEntity<PacienteSalidaDto> obtenerPacientePorId(@PathVariable Long id){
        return new ResponseEntity<>(iPacienteService.buscarPacientePorId(id),HttpStatus.OK);
    }




    @GetMapping("listar")
    public ResponseEntity<List<PacienteSalidaDto>> listarPacientes(){
            return new ResponseEntity<>(iPacienteService.listarPacientes(),HttpStatus.OK);
        }

        @PutMapping("actualizar")
    public PacienteSalidaDto actualizarPaciente(@RequestBody PacienteModificacionEntradaDto paciente) throws ResourcesNotFoundException {
        return iPacienteService.actualizarPaciente(paciente);
        }

        @DeleteMapping("eliminar/{id}")
    public ResponseEntity <?> eliminarPaciente(@PathVariable Long id ) throws ResourcesNotFoundException{
        iPacienteService.eliminarPaciente(id);
        return new ResponseEntity<>("Paciente eliminado correctamente",HttpStatus.OK);


        }



    }


