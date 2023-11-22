package com.example.condosa_registrar_recaudacionbackend.controller;

import com.example.condosa_registrar_recaudacionbackend.controller.dto.RecaudacionDto;
import com.example.condosa_registrar_recaudacionbackend.model.*;
import com.example.condosa_registrar_recaudacionbackend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/recaudacion")
public class RecaudacionController {

    @Autowired
    private RecaudacionRepository recaudacionRepository;

    @GetMapping()
    public List<RecaudacionDto> obtenerRecaudaciones() {
        List<Recaudacion> recaudaciones = recaudacionRepository.findAll();

        // Ordenar la lista por idRecaudacion de mayor a menor
        recaudaciones.sort(Comparator.comparing(Recaudacion::getIdRecaudacion).reversed());

        // Alternativamente, puedes usar Collections.sort para ordenarla de la siguiente manera:
        // Collections.sort(recaudaciones, Comparator.comparing(Recaudacion::getIdRecaudacion).reversed());

        System.out.println(recaudaciones.toString());

        return recaudaciones.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @PostMapping("/guardar")
    public Recaudacion guardarRecaudacion2(@RequestBody Recaudacion recaudacion) {
        return recaudacionRepository.save(recaudacion);
    }

    private RecaudacionDto convertToDTO(Recaudacion recaudacion) {
        RecaudacionDto recaudacionDTO = new RecaudacionDto();

        Date fechaOperacion = recaudacion.getFechaOperacion();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormateada = formatoFecha.format(fechaOperacion);

        String nombreCompleto = recaudacion.getCuenta().getPersona().getApellidoPaterno() + " " +
                recaudacion.getCuenta().getPersona().getApellidoMaterno() + " " +
                recaudacion.getCuenta().getPersona().getNombres();

        // Reemplazar '\n' por un espacio en blanco
        nombreCompleto = nombreCompleto.replace("\n", " ");

        recaudacionDTO.setIdRecaudacion(recaudacion.getIdRecaudacion());
        recaudacionDTO.setNombre(nombreCompleto);
        recaudacionDTO.setNOperacion(recaudacion.getNOperacion());
        recaudacionDTO.setFechaOperacion(fechaFormateada.toString());
        recaudacionDTO.setImporte(recaudacion.getImporte());
        recaudacionDTO.setPredio(recaudacion.getCuentaPredio().getPredio().getDescripcion());
        recaudacionDTO.setEstado(recaudacion.getRecaudacionEstado().getDescripcion());

        return recaudacionDTO;
    }



}
