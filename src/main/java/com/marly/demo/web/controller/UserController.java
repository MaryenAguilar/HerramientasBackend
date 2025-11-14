package com.marly.demo.web.controller;

import com.marly.demo.Domain.User;
import com.marly.demo.Domain.Service.UsuarioService;
import com.marly.demo.Persistance.Entity.Usuario;
import com.marly.demo.Persistance.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UsuarioService usuarioService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UsuarioService usuarioService, UserMapper userMapper) {
        this.usuarioService = usuarioService;
        this.userMapper = userMapper;
    }

    // Crear usuario desde admin
    @PostMapping
    public ResponseEntity<User> crearUsuario(@RequestBody User user) {
        if (usuarioService.existeCorreo(user.getEmail())) {
            return ResponseEntity.badRequest().build();
        }

        User nuevoUsuario = usuarioService.crearUsuarioAdmin(user);
        return ResponseEntity.ok(nuevoUsuario);
    }

    // Obtener usuario por correo
    @GetMapping("/{correo}")
    public ResponseEntity<User> obtenerUsuario(@PathVariable String correo) {
        Usuario usuarioEntity = usuarioService.obtenerEntidadPorCorreo(correo);
        if (usuarioEntity == null) {
            return ResponseEntity.notFound().build();
        }
        User usuario = userMapper.toUser(usuarioEntity);
        return ResponseEntity.ok(usuario);
    }

    // Actualizar usuario desde admin
    @PutMapping("/{correo}")
    public ResponseEntity<User> actualizarUsuario(@PathVariable String correo, @RequestBody User userActualizado) {
        Usuario usuarioExistente = usuarioService.obtenerEntidadPorCorreo(correo);
        if (usuarioExistente == null) return ResponseEntity.notFound().build();

        User usuarioDom = userMapper.toUser(usuarioExistente);

        usuarioDom.setFirstName(userActualizado.getFirstName());
        usuarioDom.setLastName(userActualizado.getLastName());
        usuarioDom.setAddress(userActualizado.getAddress());
        usuarioDom.setPhone(userActualizado.getPhone());
        usuarioDom.setDni(userActualizado.getDni()); // <-- agregado
        if (userActualizado.getPassword() != null && !userActualizado.getPassword().isEmpty()) {
            usuarioDom.setPassword(userActualizado.getPassword());
        }

        // Actualizar roles si se envían
        if (userActualizado.getRoles() != null && !userActualizado.getRoles().isEmpty()) {
            usuarioDom.setRoles(userActualizado.getRoles());
        }

        User actualizado = usuarioService.actualizarUsuario(usuarioDom);
        return ResponseEntity.ok(actualizado);
    }

    // Eliminar usuario
    @DeleteMapping("/{correo}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable String correo) {
        Usuario usuarioExistente = usuarioService.obtenerEntidadPorCorreo(correo);
        if (usuarioExistente == null) return ResponseEntity.notFound().build();

        usuarioService.eliminarUsuario(usuarioExistente.getId());
        return ResponseEntity.noContent().build();
    }

    // Obtener todos los usuarios
    @GetMapping
    public ResponseEntity<List<User>> obtenerTodosUsuarios() {
        List<Usuario> usuarios = usuarioService.obtenerTodosUsuarios();
        List<User> users = usuarios.stream()
                .map(userMapper::toUser)
                .collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }
}
