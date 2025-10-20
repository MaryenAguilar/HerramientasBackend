package com.marly.demo.Persistance;

import com.marly.demo.Domain.User;
import com.marly.demo.Domain.Repository.UserRepository;
import com.marly.demo.Persistance.Entity.Usuario;
import com.marly.demo.Persistance.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public class UsuarioRepository {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper mapper;

    public User save(User user) {
        Usuario usuario = mapper.toUsuario(user);
        Usuario saved = userRepository.save(usuario);
        return mapper.toUser(saved);
    }

    public Optional<User> findByCorreo(String correo) {
        return userRepository.findByCorreo(correo)
                .map(mapper::toUser);
    }

    public boolean existsByCorreo(String correo) {
        return userRepository.existsByCorreo(correo);
    }

    public Optional<Usuario> findUsuarioByCorreo(String correo) {
        return userRepository.findByCorreo(correo);
    }
}
