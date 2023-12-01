package com.backend.clinicaodontologica.controller;


import com.backend.clinicaodontologica.dto.entrada.odontologo.OdontologoEntradaDto;
import com.backend.clinicaodontologica.dto.modificacion.OdontologoModificacionEntradaDto;
import com.backend.clinicaodontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.clinicaodontologica.exceptions.ResourcesNotFoundException;
import com.backend.clinicaodontologica.service.IOdontologoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/odontologos")
@CrossOrigin
public class OdontologoController {
    private final IOdontologoService iOdontologoService;

    public OdontologoController(IOdontologoService iOdontologoService) {
        this.iOdontologoService = iOdontologoService;
    }


    @PostMapping("registrar")

    public ResponseEntity<OdontologoSalidaDto> registrarOdontologo(@Valid @RequestBody OdontologoEntradaDto odontologo) {
        return new ResponseEntity<>(iOdontologoService.registrarOdontologo(odontologo), HttpStatus.CREATED);
    }


    @PutMapping("actualizar")
    public ResponseEntity<OdontologoSalidaDto> actualizarOdontologo(@Valid @RequestBody OdontologoModificacionEntradaDto odontologo) throws ResourcesNotFoundException {
        return new ResponseEntity<>(iOdontologoService.actualizarOdontologo(odontologo), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<OdontologoSalidaDto> obtenerOdontologoPorId(@PathVariable Long id) {
        return new ResponseEntity<>(iOdontologoService.buscarOdontologoPorId(id), HttpStatus.OK);
    }

    @GetMapping("listar")
    public ResponseEntity<List<OdontologoSalidaDto>> listarOdontologos() {
        return new ResponseEntity<>(iOdontologoService.listarOdontologos(), HttpStatus.OK);
    }
    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable Long id) throws ResourcesNotFoundException {
        iOdontologoService.eliminarOdontologo(id);
        return new ResponseEntity<>("Odontologo eliminado correctamente", HttpStatus.OK);


    }

}
