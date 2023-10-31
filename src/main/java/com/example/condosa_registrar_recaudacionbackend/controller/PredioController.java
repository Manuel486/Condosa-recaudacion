package com.example.condosa_registrar_recaudacionbackend.controller;

import com.example.condosa_registrar_recaudacionbackend.controller.dto.CuentaPredioDto;
import com.example.condosa_registrar_recaudacionbackend.model.CuentaPredio;
import com.example.condosa_registrar_recaudacionbackend.repository.CuentaPredioRepository;
import com.example.condosa_registrar_recaudacionbackend.repository.RecaudacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/predio")
@CrossOrigin("*")
public class PredioController {

    @Autowired
    private CuentaPredioRepository cuentaPredioRepository;

//    @Autowired
//    private RecaudacionRepository recaudacionRepository;

    @GetMapping("/predio_ruc/{ruc}")
    private ResponseEntity<CuentaPredioDto> getPredioByRuc(@PathVariable("ruc") String ruc ){
        CuentaPredio cuentaPredio = cuentaPredioRepository.findByPredio_Ruc(ruc);
//        CuentaPredio cuentaPredio = recaudacionRepository.findPredioByRuc(ruc);

        if (cuentaPredio == null) {
            // El recibo no se encontró, devuelve un estado 404 Not Found
            return ResponseEntity.notFound().build();
        }

        CuentaPredioDto cuentaPredioDto = new CuentaPredioDto();

        cuentaPredioDto.setIdCuentaPredio(cuentaPredio.getIdCuentaPredio());
        cuentaPredioDto.setNombre(cuentaPredio.getPredio().getDescripcion());
        cuentaPredioDto.setDirrecion(cuentaPredio.getPredio().getDireccion());
        cuentaPredioDto.setTipoDePredio(cuentaPredio.getPredio().getTipoPredio().getNombrePredio());
        cuentaPredioDto.setTipoAutorizacion(cuentaPredio.getTipoAutorizacion().getDescripcion());
        cuentaPredioDto.setNrCuentaPredio(cuentaPredio.getNCuenta());
        cuentaPredioDto.setEstado(cuentaPredio.getEstado().getDescripcion());

        return ResponseEntity.ok(cuentaPredioDto);
    }
}
