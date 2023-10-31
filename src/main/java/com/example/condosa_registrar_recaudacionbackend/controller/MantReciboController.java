package com.example.condosa_registrar_recaudacionbackend.controller;

import com.example.condosa_registrar_recaudacionbackend.controller.dto.MantenimientoReciboDto;
import com.example.condosa_registrar_recaudacionbackend.model.MantenimientoRecibo;
import com.example.condosa_registrar_recaudacionbackend.model.Recaudacion;
import com.example.condosa_registrar_recaudacionbackend.repository.MantenimientoReciboRepository;
import com.example.condosa_registrar_recaudacionbackend.repository.RecaudacionRepository;
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

    @Autowired
    private RecaudacionRepository recaudacionRepository;

    @GetMapping("/nro_recibo/{recibo}")
    public ResponseEntity<MantenimientoReciboDto> getMantReciboByRecibo(@PathVariable("recibo") String recibo ){
        MantenimientoRecibo mantenimientoRecibo = mantenimientoReciboRepository.findMantenimientoReciboByRecibo(recibo);
//        MantenimientoRecibo mantenimientoRecibo = recaudacionRepository.findMantReciboByRecibo(recibo);

        if (mantenimientoRecibo == null) {
            // El recibo no se encontró, devuelve un estado 404 Not Found
            return ResponseEntity.notFound() .build();
        }

        MantenimientoReciboDto mantenimientoReciboDto = new MantenimientoReciboDto();

        mantenimientoReciboDto.setIdMantRecibo(mantenimientoRecibo.getIdMantenimientoRecibo());
        mantenimientoReciboDto.setEstadoRecibo(mantenimientoRecibo.getReciboEstado().getDescripcion());
        mantenimientoReciboDto.setImporte(mantenimientoRecibo.getImporte());

        return ResponseEntity.ok(mantenimientoReciboDto);
    }
}
