package com.example.condosa_registrar_recaudacionbackend.controller;

import com.example.condosa_registrar_recaudacionbackend.controller.dto.CuentaPredioDto;
import com.example.condosa_registrar_recaudacionbackend.model.CuentaPredio;
import com.example.condosa_registrar_recaudacionbackend.repository.CuentaPredioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/predio")
@CrossOrigin("*")
public class PredioController {

    @Autowired
    private CuentaPredioRepository cuentaPredioRepository;

    @GetMapping("/predio_ruc/{ruc}")
    private ResponseEntity<CuentaPredioDto> getPredioByRuc(@PathVariable("ruc") String ruc ){
        CuentaPredio cuentaPredio = cuentaPredioRepository.findByPredio_Ruc(ruc);
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
