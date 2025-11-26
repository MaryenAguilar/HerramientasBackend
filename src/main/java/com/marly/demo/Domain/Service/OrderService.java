package com.marly.demo.Domain.Service;

import com.marly.demo.Domain.Order;
import com.marly.demo.Domain.Repository.OrderItemRepository;
import com.marly.demo.Domain.Repository.OrderRepository;
import com.marly.demo.Persistance.Crud.ProductoCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ProductoCrudRepository productoRepository;

    @Autowired
    private OrderRepository orderRepository;

    //Obtener todas las órdenes
    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    //Obtener una orden específica
    public Optional<Order> getOrder(Integer orderId) {
        return orderRepository.getOrder(orderId);
    }

    //Obtener todas las órdenes de un comprador específico
    public List<Order> getByUser(Integer userID) {
        return orderRepository.getByUser(userID);
    }

    //Guardar o actualizar una orden
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    //Eliminar una orden, dudo mucho que lo usemos
    public boolean delete(Integer orderId) {
        return getOrder(orderId)
                .map(order -> {
                    orderRepository.delete(orderId);
                    return true;
                })
                .orElse(false);
    }

}
