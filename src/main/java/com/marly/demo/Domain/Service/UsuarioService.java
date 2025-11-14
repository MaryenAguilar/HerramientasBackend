package com.marly.demo.Domain.Service;

import com.marly.demo.Domain.User;
import com.marly.demo.Domain.Repository.RoleRepository;
import com.marly.demo.Persistance.UsuarioRepository;
import com.marly.demo.Persistance.Entity.Usuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Collections;
import com.marly.demo.Persistance.Mapper.UserMapper;
import java.util.List;



@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UsuarioService(UsuarioRepository usuarioRepository, RoleRepository roleRepository, UserMapper userMapper) {
        this.usuarioRepository = usuarioRepository;
        this.roleRepository = roleRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public boolean existeCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo).isPresent();
    }

    public void asignarRol(User usuario, String nombreRol) {
        roleRepository.findByRoleName(nombreRol)
                .ifPresent(rol -> usuario.setRoles(Collections.singleton(rol)));
    }

    public User registrarUsuario(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return usuarioRepository.save(user);
    }

    public boolean validarCredenciales(String correo, String contrasenia) {
        return usuarioRepository.findByCorreo(correo)
                .map(user -> passwordEncoder.matches(contrasenia, user.getPassword()))
                .orElse(false);
    }

    public Usuario obtenerEntidadPorCorreo(String correo) {
        return usuarioRepository.findUsuarioByCorreo(correo).orElse(null);
    }

   public User actualizarUsuario(User user) {
    
    if (user.getPassword() != null) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }
    return usuarioRepository.save(user);
}

public void eliminarUsuario(Long id) {
    usuarioRepository.deleteById(id);
}

public List<Usuario> obtenerTodosUsuarios() {
    return usuarioRepository.findAll();
}

public User crearUsuarioAdmin(User user) {
        if (user.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }

       
        if (user.getRoles() == null || user.getRoles().isEmpty()) {
            asignarRol(user, "USUARIO");
        }

        return usuarioRepository.save(user);
    }


}
