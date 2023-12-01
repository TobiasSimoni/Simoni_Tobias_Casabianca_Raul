package com.backend.clinicaodontologica.service;

import com.backend.clinicaodontologica.dto.entrada.turno.TurnoEntradaDto;
import com.backend.clinicaodontologica.dto.modificacion.TurnoModificacionEntradaDto;
import com.backend.clinicaodontologica.dto.salida.turno.TurnoSalidaDto;
import com.backend.clinicaodontologica.exceptions.BadRequestException;
import com.backend.clinicaodontologica.exceptions.ResourcesNotFoundException;

import java.lang.module.ResolutionException;
import java.util.List;

public interface ITurnoService {

    TurnoSalidaDto registrarTurno(TurnoEntradaDto turnoEntradaDto) throws BadRequestException;

    List<TurnoSalidaDto> listarTurnos();


    TurnoSalidaDto buscarturnoporid(Long id);

    void eliminarturno(Long id)throws  ResourcesNotFoundException;

    TurnoSalidaDto modificarturno(TurnoModificacionEntradaDto turnoModificacionEntradaDto)throws ResourcesNotFoundException;
}
