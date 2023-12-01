package com.backend.clinicaodontologica.service.impl;

import com.backend.clinicaodontologica.dto.entrada.odontologo.OdontologoEntradaDto;
import com.backend.clinicaodontologica.dto.salida.odontologo.OdontologoSalidaDto;

import com.backend.clinicaodontologica.entity.Odontologo;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OdontologoServiceTest {

    @Autowired
    private OdontologoService odontologoService;


    @Test
    @Order(1)
    void  deberiaregistrarUnOdontologoDeNombreTobiasYRetornarElid(){
        OdontologoEntradaDto odontologoEntradaDto = new OdontologoEntradaDto("232324242","tobias","simoni");
        OdontologoSalidaDto odontologoSalidaDto = odontologoService.registrarOdontologo(odontologoEntradaDto);

        assertNotNull(odontologoSalidaDto.getId());
        assertEquals("tobias",odontologoSalidaDto.getNombre());



    }



    @Test
    @Order(2)
    void deberialistartodoslosodontologos(){
        List<OdontologoSalidaDto> odontologoSalidaDtoList = odontologoService.listarOdontologos();
        assertFalse(odontologoSalidaDtoList.isEmpty());
    }







    }




