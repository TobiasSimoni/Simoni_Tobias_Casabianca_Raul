package com.backend.clinicaodontologica.service.impl;


import com.backend.clinicaodontologica.dto.entrada.paciente.PacienteEntradaDto;
import com.backend.clinicaodontologica.dto.entrada.turno.TurnoEntradaDto;

import com.backend.clinicaodontologica.dto.modificacion.PacienteModificacionEntradaDto;
import com.backend.clinicaodontologica.dto.modificacion.TurnoModificacionEntradaDto;
import com.backend.clinicaodontologica.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.clinicaodontologica.dto.salida.paciente.PacienteSalidaDto;
import com.backend.clinicaodontologica.dto.salida.turno.OdontologoTurnoSalidaDto;
import com.backend.clinicaodontologica.dto.salida.turno.PacienteTurnoSalidaDto;
import com.backend.clinicaodontologica.dto.salida.turno.TurnoSalidaDto;

import com.backend.clinicaodontologica.entity.Paciente;
import com.backend.clinicaodontologica.entity.Turno;
import com.backend.clinicaodontologica.exceptions.BadRequestException;
import com.backend.clinicaodontologica.exceptions.ResourcesNotFoundException;
import com.backend.clinicaodontologica.repository.TurnoRepository;
import com.backend.clinicaodontologica.service.ITurnoService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService implements ITurnoService {
    private final Logger LOGGER = LoggerFactory.getLogger(TurnoService.class);

    private final TurnoRepository turnoRepository;
    private final ModelMapper modelMapper;

    private final PacienteService pacienteService;
    private final OdontologoService odontologoService;
    @Autowired
    public TurnoService(TurnoRepository turnoRepository, ModelMapper modelMapper, PacienteService pacienteService, OdontologoService odontologoService) {
        this.turnoRepository = turnoRepository;
        this.modelMapper = modelMapper;
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
    }





@Override
public TurnoSalidaDto registrarTurno(TurnoEntradaDto turnoEntradaDto) throws BadRequestException {


            TurnoSalidaDto turnoSalidaDto;
            PacienteSalidaDto paciente = pacienteService.buscarPacientePorId(turnoEntradaDto.getPacienteid());
            OdontologoSalidaDto odontologo = odontologoService.buscarOdontologoPorId(turnoEntradaDto.getOdontologoid());

            if(paciente == null || odontologo == null){
                if (paciente == null && odontologo == null ){


                    LOGGER.error("El paciente y el odontologo no se encuentra en la base de datos");
                    throw new BadRequestException("\"El paciente y el odontologo no se encuentra en la base de datos");

                } else if (paciente == null) {
                    LOGGER.error("El paciente no se encuentra en la base de datos");
                    throw new BadRequestException("El paciente no se encuentra en la base de datos");


                }else {
                    LOGGER.error("El odontologo no se encuentra en la base de datos");
                    throw new BadRequestException("El odontologo no se encuentra en la base de datos");

                }
            } else{

                Turno turnoNuevo = turnoRepository.save(modelMapper.map(turnoEntradaDto, Turno.class));
                turnoSalidaDto = entidadADto(turnoNuevo);

                LOGGER.info("Se registro un nuevo turno  con exito: {}", turnoSalidaDto);
            }



            return  turnoSalidaDto;

        }

@Override
   public List<TurnoSalidaDto> listarTurnos(){
    List<TurnoSalidaDto> turnos = turnoRepository.findAll().stream()
            .map(Turno->modelMapper.map(Turno, TurnoSalidaDto.class)).toList();
    LOGGER.info("Listado de turnos:{}",turnos);
    return turnos;
}

@Override
public TurnoSalidaDto buscarturnoporid(Long id){
        Turno turnobuscado = turnoRepository.findById(id).orElse(null);

 TurnoSalidaDto turnoSalidaDto = null;
 if (turnobuscado != null){
turnoSalidaDto = modelMapper.map(turnobuscado,TurnoSalidaDto.class);
LOGGER.info("Turno encontrado : {}",turnoSalidaDto);

 }else {LOGGER.error("el id no se encuentra registrado en nuestra base de datos");
}
 return turnoSalidaDto;
}

@Override
public void eliminarturno(Long id)throws  ResourcesNotFoundException{
        if (buscarturnoporid(id) !=null){
            turnoRepository.deleteById(id);
            LOGGER.warn("Se ha eliminado el turno con id: {}",id);
        } else {
            LOGGER.error("No se ha encontrado el turno con id{}",id);
            throw new ResourcesNotFoundException("No se ha encontrado el turno con id{}"+id);
        }

}
@Override
public TurnoSalidaDto modificarturno(TurnoModificacionEntradaDto turnoModificacionEntradaDto)throws ResourcesNotFoundException{
    TurnoSalidaDto turnoSalidaDto;
        Turno turnoRecibido = modelMapper.map(turnoModificacionEntradaDto,Turno.class);
        Turno turnoaActualizar = turnoRepository.findById(turnoModificacionEntradaDto.getId()).orElse(null);

        if (turnoaActualizar != null){
            turnoaActualizar = turnoRecibido;

            turnoRepository.save(turnoaActualizar);

            turnoSalidaDto = modelMapper.map(turnoaActualizar,TurnoSalidaDto.class);

            LOGGER.warn("Turno actualizado:{}",turnoSalidaDto);

        }else{
            LOGGER.error("No fue posible actualizar los datos ya que el turno no es encuentra registrado");
            throw new ResourcesNotFoundException("No fue posible actualizar los datos ya que el turno no es encuentra registrado");

}
return turnoSalidaDto;
}


private PacienteTurnoSalidaDto pacienteSalidaDtoaSalidaTurnoDto(Long id){
        return modelMapper.map(pacienteService.buscarPacientePorId(id), PacienteTurnoSalidaDto.class);


}

private OdontologoTurnoSalidaDto odontologoSalidaDtoASalidaTurnoDto(Long id){
        return modelMapper.map(odontologoService.buscarOdontologoPorId(id),OdontologoTurnoSalidaDto.class);
    }


 private TurnoSalidaDto entidadADto(Turno turno){
        TurnoSalidaDto turnoSalidaDto = modelMapper.map(turno, TurnoSalidaDto.class);
        turnoSalidaDto.setPacienteTurnoSalidaDto(pacienteSalidaDtoaSalidaTurnoDto(turno.getId()));
        turnoSalidaDto.setOdontologoTurnoSalidaDto(odontologoSalidaDtoASalidaTurnoDto(turno.getId()));
        return turnoSalidaDto;
 }





}








