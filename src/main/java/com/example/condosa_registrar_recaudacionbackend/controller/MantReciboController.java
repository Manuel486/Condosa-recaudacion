package com.example.condosa_registrar_recaudacionbackend.controller;

import com.example.condosa_registrar_recaudacionbackend.controller.dto.MantenimientoReciboDto;
import com.example.condosa_registrar_recaudacionbackend.model.MantenimientoRecibo;
import com.example.condosa_registrar_recaudacionbackend.repository.MantenimientoReciboRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/mant_recibo")
@CrossOrigin("*")
public class MantReciboController {

    @Autowired
    private MantenimientoReciboRepository mantenimientoReciboRepository;

    @GetMapping("/nro_recibo/{recibo}")
    public ResponseEntity<MantenimientoReciboDto> getMantReciboByRecibo(@PathVariable("recibo") String recibo ){
        MantenimientoRecibo mantenimientoRecibo = mantenimientoReciboRepository.findMantenimientoReciboByRecibo(recibo);
        MantenimientoReciboDto mantenimientoReciboDto = new MantenimientoReciboDto();

        mantenimientoReciboDto.setIdMantRecibo(mantenimientoRecibo.getIdMantenimientoRecibo());
        mantenimientoReciboDto.setEstadoRecibo(mantenimientoRecibo.getReciboEstado().getDescripcion());
        mantenimientoReciboDto.setImporte(mantenimientoRecibo.getImporte());

        return ResponseEntity.ok(mantenimientoReciboDto);
    }
}
