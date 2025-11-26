package com.marly.demo.Persistance;

import com.marly.demo.Domain.OrderItem;
import com.marly.demo.Domain.Repository.OrderItemRepository;
import com.marly.demo.Persistance.Crud.PedidoCrudRepository;
import com.marly.demo.Persistance.Crud.PedidoItemCrudRepository;
import com.marly.demo.Persistance.Crud.ProductoCrudRepository;
import com.marly.demo.Persistance.Entity.Pedido;
import com.marly.demo.Persistance.Entity.Pedido_Item;
import com.marly.demo.Persistance.Entity.Producto;
import com.marly.demo.Persistance.Mapper.OrderItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PedidoItemRepository implements OrderItemRepository {
    @Autowired
    private PedidoItemCrudRepository pedidoItemCrudRepository;

    @Autowired
    private OrderItemMapper mapper;

    @Autowired
    private PedidoCrudRepository pedidoCrudRepository;

    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    @Override
    public List<OrderItem> getAll() {
        List<Pedido_Item> items = (List<Pedido_Item>) pedidoItemCrudRepository.findAll();
        return mapper.toOrderItems(items);
    }

    @Override
    public Optional<OrderItem> getOrderItem(Integer orderItemId) {
        return pedidoItemCrudRepository.findById(orderItemId)
                .map(mapper::toOrderItem);
    }

    @Override
    public List<OrderItem> getByOrder(Integer orderId) {
        return mapper.toOrderItems(pedidoItemCrudRepository.findByPedidoIdPedido(orderId));
    }

    @Override
    public OrderItem save(OrderItem orderItem) {
        Pedido_Item item = mapper.toPedidoItem(orderItem);

        // Traer pedido y producto desde la DB
        Pedido pedido = pedidoCrudRepository.findById(orderItem.getOrderId())
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
        Producto producto = productoCrudRepository.findById(orderItem.getProductId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        item.setPedido(pedido);
        item.setProducto(producto);

        Pedido_Item savedItem = pedidoItemCrudRepository.save(item);
        return mapper.toOrderItem(savedItem);
    }

    @Override
    public void delete(Integer orderItemId) {
        pedidoItemCrudRepository.deleteById(orderItemId);
    }
}
