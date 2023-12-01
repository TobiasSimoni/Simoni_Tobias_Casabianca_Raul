package com.backend.clinicaodontologica.dto.modificacion;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TurnoModificacionEntradaDto {
    @NotNull(message = "Debe proveerse el id del turno que se desea modificar")
    private Long id;
    @NotNull(message = "El paciente no puede ser nulo")
    private Long paciente;
    @NotNull(message = "El odontologo no puede ser nulo")
    private Long odontologo;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "La fehca no puede ser anterior al dia de hoy")
    @NotNull(message = "Debe especificarse la fecha y hora del turno")
    private LocalDateTime fechayhora;


    public TurnoModificacionEntradaDto() {
    }

    public TurnoModificacionEntradaDto(Long id, Long paciente, Long odontologo, LocalDateTime fechayhora) {
        this.id = id;
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fechayhora = fechayhora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPaciente() {
        return paciente;
    }

    public void setPaciente(Long paciente) {
        this.paciente = paciente;
    }

    public Long getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Long odontologo) {
        this.odontologo = odontologo;
    }

    public LocalDateTime getFechayhora() {
        return fechayhora;
    }

    public void setFechayhora(LocalDateTime fechayhora) {
        this.fechayhora = fechayhora;
    }
}
