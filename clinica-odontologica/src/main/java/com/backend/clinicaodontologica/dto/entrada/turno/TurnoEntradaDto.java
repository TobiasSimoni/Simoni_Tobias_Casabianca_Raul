package com.backend.clinicaodontologica.dto.entrada.turno;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TurnoEntradaDto {
    @NotNull(message = "El paciente no puede ser nulo")
    private Long pacienteid;
    @NotNull(message = "El odontologo no puede ser nulo")
    private Long odontologoid;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm" )
    @FutureOrPresent(message = "La fehca no puede ser anterior al dia de hoy")
    @NotNull(message = "Debe especificarse la fecha y hora del turno")
    private LocalDateTime fechayhora;

    public TurnoEntradaDto() {
    }

    public TurnoEntradaDto(Long pacienteid, Long odontologoid, LocalDateTime fechayhora) {
        this.pacienteid = pacienteid;
        this.odontologoid = odontologoid;
        this.fechayhora = fechayhora;
    }

    public Long getPacienteid() {
        return pacienteid;
    }

    public void setPacienteid(Long pacienteid) {
        this.pacienteid = pacienteid;
    }

    public Long getOdontologoid() {
        return odontologoid;
    }

    public void setOdontologoid(Long odontologoid) {
        this.odontologoid = odontologoid;
    }

    public LocalDateTime getFechayhora() {
        return fechayhora;
    }

    public void setFechayhora(LocalDateTime fechayhora) {
        this.fechayhora = fechayhora;
    }
}
