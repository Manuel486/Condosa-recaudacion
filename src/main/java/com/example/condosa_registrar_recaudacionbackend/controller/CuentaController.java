package com.example.condosa_registrar_recaudacionbackend.controller;

import com.example.condosa_registrar_recaudacionbackend.controller.dto.CuentaDto;
import com.example.condosa_registrar_recaudacionbackend.model.Cuenta;
import com.example.condosa_registrar_recaudacionbackend.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cuenta")
@CrossOrigin("*")
public class CuentaController {

    @Autowired
    private CuentaRepository cuentaRepository;

    @GetMapping("/persona_nroDocumento/{nroDocumento}")
    public ResponseEntity<CuentaDto> getCuentaById(@PathVariable("nroDocumento") String dni){
        Cuenta cuenta = cuentaRepository.findByPersona_Documento(dni);
        CuentaDto cuentaDto = new CuentaDto();

        cuentaDto.setIdCuenta(cuenta.getIdCuenta());
        cuentaDto.setNombre(cuenta.getPersona().getNombres());
        cuentaDto.setBanco(cuenta.getBanco().getDescripcion());
        cuentaDto.setMoneda(cuenta.getTipoMoneda().getDescripcion());
        cuentaDto.setNroCuenta(cuenta.getNCuenta());
        return ResponseEntity.ok(cuentaDto);
    }
}
