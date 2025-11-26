package com.marly.demo.Domain.Service;

import com.marly.demo.Domain.OrderItem;
import com.marly.demo.Domain.Repository.OrderItemRepository;
import com.marly.demo.Persistance.Crud.PedidoCrudRepository;
import com.marly.demo.Persistance.Crud.PedidoItemCrudRepository;
import com.marly.demo.Persistance.Crud.ProductoCrudRepository;
import com.marly.demo.Persistance.Crud.UsuarioCrudRepository;
import com.marly.demo.Persistance.Entity.Pedido;
import com.marly.demo.Persistance.Entity.Pedido_Item;
import com.marly.demo.Persistance.Entity.Producto;
import com.marly.demo.Persistance.Entity.Usuario;
import com.marly.demo.Persistance.Mapper.OrderItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private PedidoCrudRepository pedidoRepository;

    @Autowired
    private UsuarioCrudRepository usuarioRepository;

    @Autowired
    private ProductoCrudRepository productoRepository;

    @Autowired
    private OrderItemMapper mapper;

    @Autowired
    private PedidoItemCrudRepository pedidoItemRepository;

    // Listar todos los items
    public List<OrderItem> getAll() {
        return orderItemRepository.getAll();
    }

    // Obtener un item por ID
    public Optional<OrderItem> getItem(Integer itemId) {
        return orderItemRepository.getOrderItem(itemId);
    }

    // Obtener items por pedido
    public List<OrderItem> getByOrder(Integer orderId) {
        return orderItemRepository.getByOrder(orderId);
    }

    // Guardar un item
    public OrderItem save(OrderItem orderItem) {
        // Convertir DTO a entidad
        Pedido_Item entity = mapper.toPedidoItem(orderItem);

        // Buscar entidades reales
        Pedido pedido = pedidoRepository.findById(orderItem.getOrderId())
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
        Producto producto = productoRepository.findById(orderItem.getProductId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        // Asignar relaciones
        entity.setPedido(pedido);
        entity.setProducto(producto);

        //Testeos, ignorar xd
        System.out.println("Guardando item con datos: "
                + entity.getCantidad() + ", "
                + entity.getPrecioUnitario() + ", "
                + entity.getTotal() + ", Pedido: "
                + entity.getPedido().getIdPedido() + ", Producto: "
                + entity.getProducto().getIdProducto());
        // Guardar
        Pedido_Item saved = pedidoItemRepository.save(entity);

        // Convertir de nuevo a DTO para devolver
        return mapper.toOrderItem(saved);
    }

    // Eliminar un item (dudo que lo usemos pero ahi esta)
    public boolean delete(Integer itemId) {
        return getItem(itemId)
                .map(item -> {
                    orderItemRepository.delete(itemId);
                    return true;
                })
                .orElse(false);
    }
}
