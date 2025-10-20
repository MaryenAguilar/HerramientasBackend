package com.marly.demo.Domain.Repository;

import com.marly.demo.Persistance.Entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Usuario,Long>{
    Optional<Usuario> findByCorreo(String correo);

    boolean existsByCorreo(String correo);
}
