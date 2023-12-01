package com.backend.clinicaodontologica.dto.entrada.odontologo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OdontologoEntradaDto {

    @NotNull(message = "La matricula del odontologo no puede ser nula")
    @NotBlank(message = "Debe especificarse la matricula del odontologo")
    @Size(min = 10,message = "El campo debe tener minimo 10 caracteres")
    private String matricula;

    @NotNull(  message = "El nombre de odontologo no puede ser nulo ")
    @NotBlank(message = "Debe especificarse el nombre del odontologo")
    @Size(max = 50,message = "El nombre del odontologo debe tener hasta 50 caracteres")
    private String nombre;

    @NotNull(  message = "El apellido de odontologo no puede ser nulo ")
    @NotBlank(message = "Debe especificarse el apellido del odontologo")
    @Size(max = 50,message = "El apellido del odontologo debe tener hasta 50 caracteres")
    private String apellido;


    public OdontologoEntradaDto() {
    }

    public OdontologoEntradaDto(String matricula, String nombre, String apellido) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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
}
