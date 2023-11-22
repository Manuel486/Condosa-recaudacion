package com.example.condosa_registrar_recaudacionbackend.controller;

import com.example.condosa_registrar_recaudacionbackend.controller.dto.CuentaDto;
import com.example.condosa_registrar_recaudacionbackend.model.Cuenta;
import com.example.condosa_registrar_recaudacionbackend.repository.CuentaRepository;
import com.example.condosa_registrar_recaudacionbackend.repository.RecaudacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cuenta")
@CrossOrigin("*")
public class CuentaController {

    @Autowired
    private CuentaRepository cuentaRepository;

    @PostMapping()
    public Cuenta guardarCuenta(@RequestBody Cuenta cuenta){
        return cuentaRepository.save(cuenta);
    }

    @GetMapping("/persona_nroDocumento/{nroDocumento}")
    public ResponseEntity<CuentaDto> getCuentaById(@PathVariable("nroDocumento") String nroDocumento){
        Cuenta cuenta = cuentaRepository.findByPersona_Documento(nroDocumento);

        if (cuenta == null) {
            // El recibo no se encontró, devuelve un estado 404 Not Found
            return ResponseEntity.notFound().build();
        }

        CuentaDto cuentaDto = new CuentaDto();

        cuentaDto.setIdCuenta(cuenta.getIdCuenta());
        cuentaDto.setNombre(cuenta.getPersona().getNombres());
        cuentaDto.setBanco(cuenta.getBanco().getDescripcion());
        cuentaDto.setMoneda(cuenta.getTipoMoneda().getDescripcion());
        cuentaDto.setNCuenta(cuenta.getNCuenta());
        return ResponseEntity.ok(cuentaDto);
    }
}
