package com.example.condosa_registrar_recaudacionbackend.services;

import com.example.condosa_registrar_recaudacionbackend.model.TipoAutorizacion;
import com.example.condosa_registrar_recaudacionbackend.repository.TipoAutorizacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoAutorizacionService {

    @Autowired
    private TipoAutorizacionRepository tipoAutorizacionRepository;

    public List<TipoAutorizacion> getAll(){
        return tipoAutorizacionRepository.findAll();
    }
}
