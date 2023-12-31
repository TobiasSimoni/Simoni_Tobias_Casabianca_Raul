package com.backend.clinicaodontologica.dto.entrada.paciente;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PacienteEntradaDto {

    @NotNull(  message = "El nombre del paciente no puede ser nulo ")
    @NotBlank(message = "Debe especificarse el nombre del paciente")
    @Size(max = 50,message = "El nombre del paciente debe tener hasta 50 caracteres")
    private String nombre;

    @NotNull(  message = "El apellido del paciente no puede ser nulo ")
    @NotBlank(message = "Debe especificarse el apellido  del paciente")
    @Size(max = 50,message = "El apellido del paciente debe tener hasta 50 caracteres")
    private String apellido;
    @NotNull(  message = "El dni del paciente no puede ser nulo ")
    @Digits(integer = 12,fraction = 0,message = "el numero debe tener como maximo 12 digitos")

    private Integer dni;

    @FutureOrPresent(message = "La fecha no puede ser anterior al dia de hoy ")
    @NotNull(message = "Debe especificarse la fecha de ingreso")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private LocalDate fechaIngreso;

    @NotNull(message = "El domicilio del paciente no puede ser nulo")
    @Valid
    private DomicilioEntradaDto domicilioEntradaDto;

    public PacienteEntradaDto() {
    }

    public PacienteEntradaDto(String nombre, String apellido, Integer dni, LocalDate fechaIngreso, DomicilioEntradaDto domicilioEntradaDto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilioEntradaDto = domicilioEntradaDto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public DomicilioEntradaDto getDomicilioEntradaDto() {
        return domicilioEntradaDto;
    }

    public void setDomicilioEntradaDto(DomicilioEntradaDto domicilioEntradaDto) {
        this.domicilioEntradaDto = domicilioEntradaDto;
    }
}


