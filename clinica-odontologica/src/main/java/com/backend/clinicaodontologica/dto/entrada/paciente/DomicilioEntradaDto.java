package com.backend.clinicaodontologica.dto.entrada.paciente;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DomicilioEntradaDto {
    @NotNull(  message = "El campo calle no puede ser nulo  ")
    @NotBlank(message = "El campo calle no puede estar en blanco")

    private String calle;

    @NotNull(  message = "El campo numero no puede ser nulo ")
    @Digits(integer = 8,fraction = 0,message = "el numero debe tener como maximo 8 digitos")

    private Integer numero;

    @NotNull(  message = "El campo localidad no puede ser nulo")
    @NotBlank(message = "El campo localidad no puede estar en blanco")

    private String localidad;

    @NotNull(  message = "El campo provincia no puede ser nulo   ")
    @NotBlank(message = "el campo provincia no puede estar en blanco")
    private String provincia;

    public DomicilioEntradaDto() {
    }


    public DomicilioEntradaDto(String calle, Integer numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}
