package com.marly.demo.Persistance;

import com.marly.demo.Domain.Order;
import com.marly.demo.Domain.Repository.OrderRepository;
import com.marly.demo.Persistance.Crud.PedidoCrudRepository;
import com.marly.demo.Persistance.Entity.Pedido;
import com.marly.demo.Persistance.Entity.Usuario;
import com.marly.demo.Persistance.Mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PedidoRepository implements OrderRepository {

    @Autowired
    private PedidoCrudRepository pedidoCrudRepository;

    @Autowired
    private OrderMapper mapper;

    @Override
    public List<Order> getAll() {
        return mapper.toOrders((List<Pedido>) pedidoCrudRepository.findAll());
    }

    @Override
    public Optional<Order> getOrder(Integer orderId) {
        return pedidoCrudRepository.findById(orderId)
                .map(pedido -> mapper.toOrder(pedido));
    }

    @Override
    public List<Order> getByUser(Integer userID) {
        return mapper.toOrders(pedidoCrudRepository.findByUsuario_Id(userID));
    }

    @Override
    public Order save(Order order) {
        Pedido pedido = mapper.toPedido(order);

        // 🔥 Convertir el estado manualmente de String → ENUM
        if (order.getStatus() != null) {
            try {
                pedido.setEstado(Pedido.EstadoPedido.valueOf(order.getStatus()));
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Estado inválido: " + order.getStatus());
            }
        }

        // Relacionar usuario
        if (order.getUserID() != null) {
            Usuario usuario = new Usuario();
            usuario.setId(Long.valueOf(order.getUserID()));
            pedido.setUsuario(usuario);
        }

        Pedido saved = pedidoCrudRepository.save(pedido);
        return mapper.toOrder(saved);
    }

    @Override
    public void delete(Integer orderId) {
        pedidoCrudRepository.deleteById(orderId);
    }
}
