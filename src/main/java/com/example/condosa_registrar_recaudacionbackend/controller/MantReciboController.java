package com.example.condosa_registrar_recaudacionbackend.controller;

import com.example.condosa_registrar_recaudacionbackend.controller.dto.MantenimientoReciboDto;
import com.example.condosa_registrar_recaudacionbackend.controller.dto.MntReciboRecaudacionDto;
import com.example.condosa_registrar_recaudacionbackend.model.Cuenta;
import com.example.condosa_registrar_recaudacionbackend.model.CuentaPredio;
import com.example.condosa_registrar_recaudacionbackend.model.MantenimientoRecibo;
import com.example.condosa_registrar_recaudacionbackend.model.Recaudacion;
import com.example.condosa_registrar_recaudacionbackend.repository.CuentaPredioRepository;
import com.example.condosa_registrar_recaudacionbackend.repository.CuentaRepository;
import com.example.condosa_registrar_recaudacionbackend.repository.MantenimientoReciboRepository;
import com.example.condosa_registrar_recaudacionbackend.repository.RecaudacionRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("/api/v1/mant_recibo")
@CrossOrigin("*")
public class MantReciboController {

    @Autowired
    private MantenimientoReciboRepository mantenimientoReciboRepository;

    @Autowired
    private RecaudacionRepository recaudacionRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private CuentaPredioRepository cuentaPredioRepository;

    @GetMapping("/nro_recibo/{recibo}")
    public ResponseEntity<MantenimientoReciboDto> getMantReciboByRecibo(@PathVariable("recibo") String recibo) {
        MantenimientoRecibo mantenimientoRecibo = mantenimientoReciboRepository.findMantenimientoReciboByRecibo(recibo);
//        MantenimientoRecibo mantenimientoRecibo = recaudacionRepository.findMantReciboByRecibo(recibo);

        if (mantenimientoRecibo == null) {
            // El recibo no se encontró, devuelve un estado 404 Not Found
            return ResponseEntity.notFound().build();
        }

        MantenimientoReciboDto mantenimientoReciboDto = new MantenimientoReciboDto();

        mantenimientoReciboDto.setIdMantRecibo(mantenimientoRecibo.getIdMantenimientoRecibo());
        mantenimientoReciboDto.setEstadoRecibo(mantenimientoRecibo.getReciboEstado().getDescripcion());
        mantenimientoReciboDto.setImporte(mantenimientoRecibo.getImporte());

        return ResponseEntity.ok(mantenimientoReciboDto);
    }

    @GetMapping("/nro_recibo/recaudacion/{recibo}")
    public ResponseEntity<MntReciboRecaudacionDto> getRecaudacion(@PathVariable("recibo") String recibo) {
        MantenimientoRecibo mantenimientoRecibo = mantenimientoReciboRepository.findMantenimientoReciboByRecibo(recibo);

        if (mantenimientoRecibo == null) {
            // El recibo no se encontró, devuelve un estado 404 Not Found
            return ResponseEntity.notFound().build();
        }

        MntReciboRecaudacionDto mntReciboRecaudacionDto = new MntReciboRecaudacionDto();
        String ruc = mantenimientoRecibo.getCasa().getPredio().getRuc();
        CuentaPredio cuentaPredio = cuentaPredioRepository.findByPredio_Ruc(ruc);
        String nroDocumento = mantenimientoRecibo.getCasa().getPredio().getPersona().getDocumento();
        Cuenta cuenta = cuentaRepository.findByPersona_Documento(nroDocumento);

        if (cuenta != null) {
            mntReciboRecaudacionDto.setIdCuenta(cuenta.getIdCuenta());
            mntReciboRecaudacionDto.setNombreCuenta(cuenta.getPersona().getNombres());
            mntReciboRecaudacionDto.setBanco(cuenta.getBanco().getDescripcion());
            mntReciboRecaudacionDto.setIdTipoMoneda(cuenta.getTipoMoneda().getIdTipoMoneda());
            mntReciboRecaudacionDto.setMoneda(cuenta.getTipoMoneda().getDescripcion());
            mntReciboRecaudacionDto.setNroCuenta(cuenta.getNCuenta());

        } else {
            mntReciboRecaudacionDto.setIdCuenta(0);
            mntReciboRecaudacionDto.setNombreCuenta("");
            mntReciboRecaudacionDto.setBanco("");
            mntReciboRecaudacionDto.setIdTipoMoneda((short) 0);
            mntReciboRecaudacionDto.setMoneda("");
            mntReciboRecaudacionDto.setNroCuenta(BigInteger.valueOf(0));
        }

        mntReciboRecaudacionDto.setNombre(mantenimientoRecibo.getCasa().getPredio().getPersona().getNombres() + " " + mantenimientoRecibo.getCasa().getPredio().getPersona().getApellidoPaterno() + " " + mantenimientoRecibo.getCasa().getPredio().getPersona().getApellidoMaterno());
        mntReciboRecaudacionDto.setIdPersona(mantenimientoRecibo.getCasa().getPredio().getPersona().getIdPersona());

        // CuentaPredio
        mntReciboRecaudacionDto.setIdCuentaPredio(cuentaPredio.getIdCuentaPredio());
        mntReciboRecaudacionDto.setNombrePredio(cuentaPredio.getPredio().getDescripcion());
        mntReciboRecaudacionDto.setDirrecion(cuentaPredio.getPredio().getDireccion());
        mntReciboRecaudacionDto.setTipoDePredio(cuentaPredio.getPredio().getTipoPredio().getNombrePredio());
        mntReciboRecaudacionDto.setNrCuentaPredio(cuentaPredio.getNCuenta());
        mntReciboRecaudacionDto.setTipoAutorizacion(cuentaPredio.getTipoAutorizacion().getDescripcion());
        mntReciboRecaudacionDto.setEstado(cuentaPredio.getEstado().getDescripcion());

        // Mantenimiento del recibo
        mntReciboRecaudacionDto.setIdMantRecibo(mantenimientoRecibo.getIdMantenimientoRecibo());
        mntReciboRecaudacionDto.setEstadoRecibo(mantenimientoRecibo.getReciboEstado().getDescripcion());
        mntReciboRecaudacionDto.setImporte(mantenimientoRecibo.getImporte());

        return ResponseEntity.ok(mntReciboRecaudacionDto);
    }


}
