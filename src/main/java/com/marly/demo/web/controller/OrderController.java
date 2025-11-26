package com.marly.demo.web.controller;

import com.marly.demo.Domain.Order;
import com.marly.demo.Domain.Service.OrderService;
import com.marly.demo.Domain.Service.UsuarioService;
import com.marly.demo.Domain.User;
import com.marly.demo.Persistance.Crud.PedidoCrudRepository;
import com.marly.demo.Persistance.Entity.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PedidoCrudRepository pedidoRepository;

    //Listar todos los pedidos
    @GetMapping("/all")
    public ResponseEntity<List<Order>> getAll() {
        List<Order> orders = orderService.getAll();
        return orders.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(orders);
    }

    //Buscar pedido por ID
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable("id") int orderId) {
        return orderService.getOrder(orderId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //Listar pedidos por comprador
    @GetMapping("/buyer/{userId}")
    public ResponseEntity<List<Order>> getByUser(@PathVariable("userId") int userId) {
        List<Order> orders = orderService.getByUser(userId);
        return orders.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(orders);
    }

    //Crear nuevo pedido
    @PostMapping("/save")
    public ResponseEntity<Order> save(@RequestBody Order order) {
        Order saved = orderService.save(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    //Eliminar pedido por ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int orderId) {
        boolean deleted = orderService.delete(orderId);
        return deleted
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<?> actualizarEstado(
            @PathVariable("id") int orderId,
            @RequestParam("estado") String estado) {

        Optional<Pedido> pedidoOpt = pedidoRepository.findById(orderId);

        if (!pedidoOpt.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Pedido pedido = pedidoOpt.get();

        try {
            pedido.setEstado(Pedido.EstadoPedido.valueOf(estado));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Estado inválido");
        }

        // 🔥 SOLO actualizar el campo "estado", NO tocar items ni producto
        pedidoRepository.save(pedido);

        return ResponseEntity.ok("Estado actualizado correctamente");
    }
}
