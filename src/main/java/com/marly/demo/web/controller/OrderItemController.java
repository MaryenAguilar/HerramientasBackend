package com.marly.demo.web.controller;

import com.marly.demo.Domain.OrderItem;
import com.marly.demo.Domain.Service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidoitems")
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;

    //Listar todos los items
    @GetMapping("/all")
    public ResponseEntity<List<OrderItem>> getAll() {
        List<OrderItem> items = orderItemService.getAll();
        return items.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(items);
    }

    //Buscar item por ID
    @GetMapping("/{id}")
    public ResponseEntity<OrderItem> getItem(@PathVariable("id") int itemId) {
        return orderItemService.getItem(itemId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //Listar items por pedido
    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<OrderItem>> getByOrder(@PathVariable("orderId") int orderId) {
        List<OrderItem> items = orderItemService.getByOrder(orderId);
        return items.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(items);
    }

    //Crear nuevo item
    @PostMapping("/save")
    public ResponseEntity<OrderItem> save(@RequestBody OrderItem item) {
        System.out.println("Recibiendo item: " + item);
        OrderItem saved = orderItemService.save(item);
        System.out.println("Item guardado: " + saved);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    //Eliminar item por ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int itemId) {
        boolean deleted = orderItemService.delete(itemId);
        return deleted
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
