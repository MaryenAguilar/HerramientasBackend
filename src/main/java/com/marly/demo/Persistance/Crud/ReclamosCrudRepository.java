package com.marly.demo.Persistance.Crud;

import com.marly.demo.Persistance.Entity.Reclamos;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ReclamosCrudRepository extends CrudRepository<Reclamos, Long> {
    List<Reclamos> findByUsuario_Id(Long userId);
    Optional<Reclamos> findByIdreclamo(Long idReclamo);
}
