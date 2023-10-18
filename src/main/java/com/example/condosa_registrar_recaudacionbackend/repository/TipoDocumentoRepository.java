package com.example.condosa_registrar_recaudacionbackend.repository;

import com.example.condosa_registrar_recaudacionbackend.model.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento,Short> {
}
